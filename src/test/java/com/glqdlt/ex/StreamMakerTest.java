package com.glqdlt.ex;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created By iw.jhun
 * On 2018-05-03
 */
public class StreamMakerTest {


    @Test
    public void shouldMakeStream() {
//        콜렉션 만들기
        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4);
        someNumbers.forEach(System.out::println);

//        콜렉션 유틸로 스트림 만들기
        IntStream someNumbersStream = Arrays.stream(new int[]{1,2,3,4});

        Stream<String> someStringsStream = Arrays.stream(new String[]{"1","2"});

//        스트림 만들기
        Stream<Integer> someStream = Stream.of(1, 2, 3, 4);
        someStream.forEach(System.out::println);

//        빈 스트림 만들기
        Stream<Integer> emptryStream = Stream.empty();



    }

}