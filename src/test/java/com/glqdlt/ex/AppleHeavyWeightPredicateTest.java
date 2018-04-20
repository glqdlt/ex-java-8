package com.glqdlt.ex;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-13
 */
public class AppleHeavyWeightPredicateTest {

    Apple apple;

    AppleHeavyWeightPredicate appleHeavyWeightPredicate;

    @Before
    public void setup(){
        this.apple = new Apple("red",160);
        appleHeavyWeightPredicate =  new AppleHeavyWeightPredicate();
    }


    @Test
    public void isAppleOverWeight150() {
        assertEquals(true, this.appleHeavyWeightPredicate.test(this.apple));

    }
}