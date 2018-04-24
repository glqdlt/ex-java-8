package com.glqdlt.ex;

import org.junit.Test;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class ArraysTest {


    private <E> void echoArray(E[] some) {

        for (E e : some) {
            if (e instanceof Apple) {
                System.out.println(((Apple) e).getColor());
            } else {
                System.out.println(e);
            }
        }
    }
    @Test
    public void arrayCopyToObject() {
        // TODO Object[] -> Apple[] 캐스팅 안 되는 이유에 대해 파악할 것
        Apple[] apples = {new Apple("red", 10), new Apple("blue", 50)};
        echoArray(Arrays.addToObject(apples, new Apple("green", 99)));
    }

}