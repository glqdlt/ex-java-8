package com.glqdlt.ex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-05-03
 */
public class UnlimitedStreamMakerTest {

    @Test
    public void shouldUnlimitedStreamMake() {
        Stream<Integer> someStream = Stream.iterate(0, x -> x + 2)
                .limit(10);
        someStream.forEach(System.out::println);
    }

    @Test
    public void shouldPretty100NumbersMaker() {

//      극혐 코드, 와 몇 줄이야 ㅅㅂ
        List<Integer> monolothicNumbers = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            monolothicNumbers.add(i);
        }
        monolothicNumbers.forEach(System.out::println);

//        아래 처럼 ++x 로 해도되는데 가독성이 더 구려서..
//        List<Integer> someNumbers = Stream.iterate(0, x -> ++x)
//        iterate 로 할 경우에 limit가 있더라도, 우선 무한 스트림을 만든다. 이를 보고 언바운드 스트림이라고 표현하는듯.
        List<Integer> someNumbers = Stream.iterate(0, x -> x + 1).limit(100).peek(System.out::println).collect(toList());
//        아래처럼 IntStream의 rangeCLosed를 활용해서 할 수도 있다. foreach 로 찍기 보단 peek을 쓰는 게 참 편하네..
        List<Integer> someNumbersAsIntStream = IntStream.rangeClosed(0, 100).boxed().peek(System.out::println).collect(toList());


    }

    @Test
    public void pibonachi() {
        Stream.iterate(new int[]{0, 1}, x -> new int[]{x[1], x[0] + x[1]})
                .limit(10)
                .peek(x -> System.out.println(x[0] + "," + x[1]))
                .collect(toList());
    }

}