package com.glqdlt.ex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-20
 */
public class DishTest {


    private List<Dish> menu = new ArrayList<>();

    public DishTest() {
        setupData();
    }

    private void setupData() {
        for (int i = 0; i < 999; i++) {
            menu.add(new Dish("some-dish" + i, (i % 3 == 0), (int) (Math.random() * 1000) + 1, ((i % 3 == 0) ? Dish.Type.MEAT : Dish.Type
                    .FISH)));

        }
    }

    @Test
    public void echoMenu() {
        menu.forEach( x -> System.out.println(x.toString()));

    }

    @Test
    public void someTest() {
        List<String> threeHighCaloricDishNames  = menu.stream().filter(d -> d.getCalories() > 500)
                .map(Dish::getName)
                .limit(100)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);
    }

}