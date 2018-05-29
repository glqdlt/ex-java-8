package com.glqdlt.ex;

import org.junit.Test;

import java.util.function.Function;

/**
 * Created By iw.jhun
 * On 2018-04-19
 */
public class FunctionMixer {

    @Test
    public void someMixFunction() {

        // function functioninterface 를 이용한 mix
        Function<Integer, Integer> f = x -> x + 1;
        Function<Integer, Integer> g = x -> x * x;
        Function<Integer, Integer> h = f.andThen(g);


        // andThen은 인자가 뒤에서 실행 됨
        System.out.println(h.apply(2));

        // compose는 인자가 먼저 실행 됨

        Function<Integer,Integer> comp = f.compose(g);

        System.out.println(comp.apply(2));



    }

    @Test
    public void someFunction(){
        Function<Integer,Integer> f = x -> x +1;
        System.out.println(f.apply(2));
    }
}
