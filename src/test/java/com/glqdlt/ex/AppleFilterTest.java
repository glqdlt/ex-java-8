package com.glqdlt.ex;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-13 , 오후 6:51
 */
public class AppleFilterTest {

    List<Apple> list = new ArrayList<>();

    @Before
    public void setup() {
        list.add(new Apple("red", 150));
        list.add(new Apple("yello", 170));
        list.add(new Apple("green", 160));
    }

    // strategy design
    @Test
    public void filterApples() {

        AppleFilter.filterApples(list, new AppleGreenColorPredicate()).forEach(x -> System.out.println(x.getWeight()));

    }
}