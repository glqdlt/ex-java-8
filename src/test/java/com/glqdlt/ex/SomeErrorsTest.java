package com.glqdlt.ex;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By iw.jhun
 * On 2018-05-08
 */
public class SomeErrorsTest {

    @Test
    public void shouldMatchErrorCode() {

        String target = "404";
        boolean result = Arrays.stream(SomeErrors.values()).map(x -> x.getCode()).anyMatch(x -> x.equals(target));

        System.out.println(result);
    }

    @Test
    public void shouldFilltedErrorCode() {

        List<SomeErrorMessage> list = IntStream.rangeClosed(0, 1000000).boxed().map(x -> {
            String a1 = "";
            String a2 = "";
            if (x % 7 == 0) {
                a1 = "404";
            } else {
                a1 = a1 + x;
            }
            a2 = a2 + x;
            return new SomeErrorMessage(a1, a2);
        }).collect(toList());


        List<SomeErrorMessage> matchedErros = list.stream().filter(x -> Arrays.stream(SomeErrors.values()).anyMatch(y -> y.getCode().equals(x.getCode()))).collect(toList());

        matchedErros.forEach(x -> System.out.println(x.toString()));

    }


}