package com.glqdlt.ex;

import org.junit.Test;

import java.util.Comparator;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created By iw.jhun
 * On 2018-05-09
 */
public class ParallelStreamTest {

    @Test
    public void 병렬_스트림_처리() {

        Long some = Stream.iterate(1L, i -> i + 1)
                .limit(100)
                .parallel()
                .reduce(0L, Long::sum);

        System.out.println(some);
    }

    @Test
    public void 병렬_박싱언박싱이_없어_성능에_좋은_특화스트림(){
        long some = LongStream.rangeClosed(1, 1000000000).reduce(0L, Long::sum);

        System.out.println(some);

    }

    @Test
    public void 스트림값에서_최대값과_최솟값의_검색(){
        Comparator<Dish> dishCalroriesComparator = Comparator.comparingInt(Dish::getCalories);
    }
}
