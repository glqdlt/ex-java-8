package com.glqdlt.ex;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-17 , 오전 11:34
 */

public class Apple2PredicateTest {

    List<Integer> someList = new ArrayList<>();

    private <T> List<T> filter(List<T> list, Apple2Predicate<T> apple2Predicate){

        List<T> result = new ArrayList<>();

            for(T item: list){
                if(apple2Predicate.test(item)){
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


}