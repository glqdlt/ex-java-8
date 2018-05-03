package com.glqdlt.ex;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created By iw.jhun
 * On 2018-05-03
 */
public class ReduceTest {


    List<Integer> numbers = new ArrayList<>();
    List<Apple> someApples = new ArrayList<>();

    public ReduceTest() {

        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        someApples.add(new Apple("red", 100));
        someApples.add(new Apple("green", 105));
        someApples.add(new Apple("yellow", 110));
        someApples.add(new Apple("pink", 120));


    }


//    reduce(초기인자, (x,y,) -> x+y) 인 이 코드를 설명하면
//    초기인자(누적 대상) 0으로 넣어놨다. 이 0은 x의 자리에 매핑된다. y는 list라는 리스트 객체 안의 값들이 매핑 된다.
//    x+y 식을 거쳐 0+1의 결과값은 다시 초기인자에 삽입 된다.
//    위의 과정을 다시 반복해서 초기인자는 1이되고, 이는 다시 x에 매핑 1+2 가 되어서 초기인자에는 3이 들어간다.. 이를 반복하고 최종적으로 수행할 연산 대상 (list의 값)이 없으면
//    누적대상(초기인자)에 할당된 모든 덧셈의 값을 return 하고 종료.
    @Test
    public void shouldAllValuesSum() {
        int result = numbers.stream().reduce(0, (x, y) ->
        {
            System.out.println(x);
            return x + y;
        });
        System.out.println(result);
    }


    // 초기값이 없을 경우, numbers의 값이 비어있을 수 있기에 reduce가 끝나고 나오는 결과 값이 null일 수도 있다.
    // 이 때문에 이 reduce는 Optional을 반환하는 기능으로 되어있다.
    @Test
    public void shouldIfInitDataIsNull() {
        List<Integer> nullNumbers = new ArrayList<>();
        Optional<Integer> ifNull = numbers.stream().reduce((x, y) -> x + y);
        System.out.println(ifNull);
        System.out.println(ifNull.isPresent());
        Assert.assertNotEquals((long) ifNull.get(), 0);

        Optional<Integer> isNull = nullNumbers.stream().reduce((x, y) -> x + y);
        System.out.println(isNull);
        System.out.println(isNull.isPresent());
        Assert.assertNotEquals((long) isNull.get(), 0);


    }

    // map 을 이용해 apple 객체의 weight만 가져온 뒤, reduce로 그 weight의 총합을 구했음.
    // reduce의 장점은 외부 반복시에 (전통적인 for-each 등)에는 스레드 간의 누적값을 공유를 해야하는 데
    // reduce는 내부 반복으로 되기에 stream()이 아닌 parallelStream()으로 할 경우 이를 알아서 병렬처리해준다. wow
    @Test
    public void shouldAllApplesWeight() {


        // 일반 단일 스레드
        Integer allApplesWeight = someApples.stream().map(x -> x.getWeight()).reduce(0, (x, y) -> x+y);
        System.out.println(allApplesWeight);

        // 병렬 스트림을 이용한 병렬 처리
        Integer allParallelApplesWeight = someApples.parallelStream().map(x -> x.getWeight()).reduce(0, (x,y) -> x+y);
        System.out.println(allParallelApplesWeight);

        Apple maxAppleWeight = someApples.stream().max(Comparator.comparingInt(x -> x.getWeight())).get();
        System.out.println(maxAppleWeight.getColor()+","+maxAppleWeight.getWeight());
    }

}