package com.glqdlt.ex;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

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

//        스트림 만들기
        Stream<Integer> someStreams = Stream.of(1, 2, 3, 4);
        someStreams.forEach(System.out::println);



    }

}