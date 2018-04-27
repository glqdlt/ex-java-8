package com.glqdlt.ex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
        menu.forEach(x -> System.out.println(x.toString()));

    }

    @Test
    public void someTest() {
        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 500)
                .map(Dish::getName)
                .limit(100)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);
    }

    @Test
    public void watchLazy() {
        List<String> list = menu.stream()
                .filter(x -> {
                    System.out.println("filtter.." + x.getName());
                    return x.getCalories() > 300;
                })
                .map(x -> {
                    System.out.println("map.." + x.getName());
                    return x.getName();
                })
                .limit(30)
                .collect(toList());

        // 예상하기론 filter 중간 연산 과정에서 menu의 999개의 아이템을 다 뒤질것으로 생각되지만.. 실제 log 출력된 걸 보면, limit(30)까지의 중간 연산을 모두 조합한 후에 실행하기 때문에..
        // 999개를 안 뒤지고 30개만 뒤지고 filter와 map을 하는 걸 볼 수있다.. 와우 이것이 lazy? 이건 쇼트서킷의 효과.
        // limit이 없다면 999개 다 뒤지겠지만, filter와 map 이 같이 조합되서 수행될 것이다. 이건 루프 퓨전 이라고 부른다.
        System.out.println("---");
        System.out.println("===");
        list.forEach(System.out::println);
    }

    @Test
    public void fianllyFunc() {
        long count = menu.stream()
                .filter(x -> {
                    System.out.println("filtter.." + x.getName());
                    return x.getCalories() > 300;
                })
                .map(x -> {
                    System.out.println("map.." + x.getName());
                    return x.getName();
                })
                .limit(30)
                .count();

        System.out.println(count);
    }

    @Test
    public void shouldStreamStringToInteger() {
        List<Integer> stringLengths = menu.stream()
                .map(x -> x.getName().length())
                .collect(toList());

    }

    @Test
    public void shouldStreamMapDouble() {
        List<String> lengthsToWord = menu.stream()
                .map(x -> x.getName().length())
                .map(x -> {
                    switch (x) {
                        case 1:
                            return "one";
                        case 2:
                            return "three";
                        case 3:
                            return "four";
                        case 12:
                            return "twelve";
                        default:
                            return "no";
                    }
                })
                .collect(toList());
        lengthsToWord.forEach(System.out::println);

    }

    @Test
    public void flatMap() {
        Stream<String> someWords = Arrays.stream(new String[]{"hello", "world", "hi", "wow"});
        List<String> someWords2 = Arrays.asList("hello","hell","how");
        List<String> splitWords = someWords
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
//                .flatMap(x -> Arrays.stream(x))
                .distinct()
                .collect(toList());

        splitWords.forEach(System.out::println);

        System.out.println("\n");
        List<String> splitWorkds2 = someWords2.stream().map(x -> x.split("")).flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        splitWorkds2.forEach(System.out::println);
    }


}