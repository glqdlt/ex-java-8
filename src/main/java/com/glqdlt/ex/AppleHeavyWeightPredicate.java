package com.glqdlt.ex;

/**
 * Created By iw.jhun
 * On 2018-04-13
 */
public class AppleHeavyWeightPredicate  implements  ApplePredicate{

    public boolean test(Apple apple) {

        return apple.getWeight() > 150;
    }
}
