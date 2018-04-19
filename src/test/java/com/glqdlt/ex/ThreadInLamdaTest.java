package com.glqdlt.ex;

import org.junit.Test;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * Created By iw.jhun
 * On 2018-04-17
 */

public class ThreadInLamdaTest {

    // 이 테스트는 @test 스레드 외의 다른 스레드에 할당 되어 동작되므로 해당 워커 스레드가 동작중이지만, @test 스레드는 종료함으로 200번까지 console에 로그가 찍히지 않는다.
    @Test
    public void someTest() {
        Thread thread = new Thread(() ->
        {
            for (int i = 0; i < 200; i++) {
                System.out.println(i);
            }
        }
        );

        Thread thread2 = new Thread(() ->
        {

            for (int i = 0; i < 100; i++) {
                System.out.println(i + "haha");
            }

        }
        );

        thread.start();
        thread2.start();
    }

    // 람다식의 사용 예
    @Test
    public void runableLamdaImplemet() {

        Runnable runnable = () -> System.out.println("Hello Lamda!");
        runnable.run();
    }

    @Test
    public void someLamda() {

        Predicate<String> predicate = item -> item.equals("q");
        System.out.println(predicate.test("q"));
        System.out.println(predicate.test("q2"));

        IntPredicate intPredicate = item -> item == 0;
        System.out.println(intPredicate.test(1));
        System.out.println(intPredicate.test(0));

        Apple apple = new Apple("red", 150);
        Apple apple2 = new Apple("green", 190);
        Function<Apple, Integer> someFunc = item -> item.getWeight();

//        This is fail
//        Function<Apple,Integer> faileSomeFunc = item -> item.getColor();

        System.out.println(someFunc.apply(apple));

        BiFunction<Apple, Apple, Integer> biFunction = (t, u) -> t.getWeight() + u.getWeight();
        System.out.println(biFunction.apply(apple,apple2));
    }
}
