package com.glqdlt.ex;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created By iw.jhun
 * On 2018-05-08
 */
public class SomeErrorsTest {


    List<SomeErrorMessage> list;

    public SomeErrorsTest() {
        list = IntStream.rangeClosed(0, 100000)
                .boxed()
                .map(x -> {
                    String a1 = "";
                    String a2 = "";
                    if (x % 7 == 0) {
                        a1 = "404";
                    } else if (x % 9 == 0) {
                        a1 = "500";
                    } else {
                        a1 = a1 + x;
                    }
                    a2 = a2 + x;
                    return new SomeErrorMessage(a1, a2);
                })
                .collect(toList());

    }

    @Test
    public void shouldMatchErrorCode() {

        String target = "404";
        boolean result = Arrays.stream(SomeErrors.values()).map(x -> x.getCode()).anyMatch(x -> x.equals(target));

        System.out.println(result);
    }

    @Test
    public void shouldFilltedOnlyErrorCodeErrorMessage() {


//        여기서 AllMatch로 할 경우에 SomeErros와 다 일치하는 가를 비교하기 때문에 하나라도 false가 떨어지게 되면 안되어서.. 원하는 결과가 나오질 않는다.
//        난 이 list의 어떠한 객체의 code가 하나라도 맞는 놈에 대해서 필터링 하고 싶은 것이므로, anyMatch를 쓴다.

        List<SomeErrorMessage> matchedErros = list.stream()
                .filter(x -> Arrays.stream(SomeErrors.values()).anyMatch(y -> y.getCode().equals(x.getCode())))
                .collect(toList());

        matchedErros.forEach(x -> System.out.println(x.toString()));

    }

    @Test
    public void shouldSingleMessageCheck() {
        Optional<SomeErrorMessage> some = Stream.of(new SomeErrorMessage("404", "hello")).filter(x -> Arrays.stream(SomeErrors.values())
                .anyMatch(y -> y
                        .getCode()
                        .equals
                                (x.getCode()))).findAny();

        System.out.println(some.isPresent());
    }


}