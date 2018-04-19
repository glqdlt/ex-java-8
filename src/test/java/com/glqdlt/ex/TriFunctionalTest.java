package com.glqdlt.ex;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-19
 */
public class TriFunctionalTest {

    @Test
    public void shouldFunctionMethodRefrence() {

        YelloApple apple = new YelloApple("red", 190, "dirty");

        System.out.println(apple);


        TriFunctional<String, Integer, String, YelloApple> methodRefernceApple = YelloApple::new;
        YelloApple someApple = methodRefernceApple.apply("green",350,"clean");

        System.out.println(someApple);

    }

}