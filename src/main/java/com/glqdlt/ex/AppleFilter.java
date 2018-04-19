package com.glqdlt.ex;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By iw.jhun
 * On 2018-04-13
 */
public class AppleFilter {

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) result.add(apple);
        }
        return result;
    }
}
