package com.glqdlt.ex;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-19
 */
public class AppMainTest {


    @Test
    public void localVariableIsMustFinal() {
        int portNumber = 1337;
        Runnable r = () -> System.out.println(portNumber);
        r.run();
    }

    @Test
    public void notLocalVariableIsMustFinal() {
//        int portNumber = 1337;
////         This is compile error
//        Runnable r = () -> System.out.println(portNumber);
//        r.run();
//        // portNumber is changed.
//        portNumber = 1555;
    }

    @Test
    public void thisIsMethodReference() {
        List<String> list = Arrays.asList("1", "3", "2");

        list.forEach(System.out::println);

//        numbers.sort((a,b) -> a.compareTo(b));
        list.sort(String::compareTo);

        list.forEach(System.out::println);
    }

    @Test
    public void thisIsMethodReference2() {
        Supplier<Apple> aNew = Apple::new;


    }

}