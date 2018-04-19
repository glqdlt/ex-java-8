package com.glqdlt.ex;

/**
 * Created By iw.jhun
 * On 2018-04-13
 */
public class AppleGreenColorPredicate implements  ApplePredicate {
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
