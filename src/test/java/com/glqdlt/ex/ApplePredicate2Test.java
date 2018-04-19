package com.glqdlt.ex;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By iw.jhun
 * On 2018-04-17
 */

public class ApplePredicate2Test {

    List<Integer> someList = new ArrayList<>();

    private <T> List<T> filter(List<T> list, ApplePredicate2<T> applePredicate2){

        List<T> result = new ArrayList<>();

            for(T item: list){
                if(applePredicate2.test(item)){
                    result.add(item);
                }
            }

        return result;
    }



    @Before
    public void setUp(){
        for(int i=0; i<999; i++){
            this.someList.add(i);
        }
    }

    @Test
    public void appleImplement(){
        filter(this.someList, (Integer i) -> i > 950).forEach(x -> System.out.println(x));
    }

    @Test
    public void someLamda(){
    }


}