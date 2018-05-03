package com.glqdlt.ex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-20
 */
public class DishTest {


    private List<Dish> menu = new ArrayList<>();

    public DishTest() {
        setupData();
    }

    private void setupData() {
        for (int i = 0; i < 999; i++) {
            menu.add(new Dish("some-dish" + i, (i % 3 == 0), (int) (Math.random() * 1000) + 1, ((i % 3 == 0) ? Dish.Type.MEAT : Dish.Type
                    .FISH)));

        }
    }

    @Test
    public void echoMenu() {
        menu.forEach(x -> System.out.println(x.toString()));

    }

    @Test
    public void someTest() {
        List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() > 500)
                .map(Dish::getName)
                .limit(100)
                .collect(toList());

        System.out.println(threeHighCaloricDishNames);
    }

    @Test
    public void watchLazy() {
        List<String> list = menu.stream()
                .filter(x -> {
                    System.out.println("filtter.." + x.getName());
                    return x.getCalories() > 300;
                })
                .map(x -> {
                    System.out.println("map.." + x.getName());
                    return x.getName();
                })
                .limit(30)
                .collect(toList());

        // 예상하기론 filter 중간 연산 과정에서 menu의 999개의 아이템을 다 뒤질것으로 생각되지만.. 실제 log 출력된 걸 보면, limit(30)까지의 중간 연산을 모두 조합한 후에 실행하기 때문에..
        // 999개를 안 뒤지고 30개만 뒤지고 filter와 map을 하는 걸 볼 수있다.. 와우 이것이 lazy? 이건 쇼트서킷의 효과.
        // limit이 없다면 999개 다 뒤지겠지만, filter와 map 이 같이 조합되서 수행될 것이다. 이건 루프 퓨전 이라고 부른다.
        System.out.println("---");
        System.out.println("===");
        list.forEach(System.out::println);
    }

    @Test
    public void fianllyFunc() {
        long count = menu.stream()
                .filter(x -> {
                    System.out.println("filtter.." + x.getName());
                    return x.getCalories() > 300;
                })
                .map(x -> {
                    System.out.println("map.." + x.getName());
                    return x.getName();
                })
                .limit(30)
                .count();

        System.out.println(count);
    }

    @Test
    public void shouldStreamStringToInteger() {
        List<Integer> stringLengths = menu.stream()
                .map(x -> x.getName().length())
                .collect(toList());

    }

    @Test
    public void shouldStreamMapDouble() {
        List<String> lengthsToWord = menu.stream()
                .map(x -> x.getName().length())
                .map(x -> {
                    switch (x) {
                        case 1:
                            return "one";
                        case 2:
                            return "three";
                        case 3:
                            return "four";
                        case 12:
                            return "twelve";
                        default:
                            return "no";
                    }
                })
                .collect(toList());
        lengthsToWord.forEach(System.out::println);

    }

    @Test
    public void flatMap() {
        Stream<String> someWords = Arrays.stream(new String[]{"hello", "world", "hi", "wow"});
        List<String> someWords2 = Arrays.asList("hello", "hell", "how");
        List<String> splitWords = someWords
                .map(x -> x.split(""))
                .flatMap(Arrays::stream)
//                .flatMap(x -> Arrays.stream(x))
                .distinct()
                .collect(toList());

        splitWords.forEach(System.out::println);

        // flatMap은 모든 배열스트림을 담을 수 있는 하나의 스트림을 만들고 거기에 통합시켜버린다. 그래서 배열이 없어진 느낌이 듬

        System.out.println("\n");
        List<String> splitWorkds2 = someWords2.stream().map(x -> x.split("")).flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        splitWorkds2.forEach(System.out::println);
    }

    @Test
    public void page155Exam() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5)
                .stream()
                .map(x -> x * x)
                .collect(toList());

        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(3, 4);

        List<int[]> numbers = integers1.stream()
                .flatMap(x -> integers2.stream()
                        .filter(y -> {
                            System.out.println("!!"+y);
                            return ((y + x) % 3 == 0);})
                        .map(y -> {
                            System.out.println(y+"yy!!");
                            return new int[]{x, y};
                        }))
//                아래는 퍼포먼스 저하가 있기 때문에 .. 왜냐면 new int[] 로 일단 배열을 만들고 filter를 거치기 때문에..
//                .filter(x -> {
//                    System.out.println(x+"xx!!");
//                    return ((x[0] + x[1]) % 3 == 0);})
                .collect(toList());

        numbers.forEach(x -> System.out.println("{" + x[0] + "," + x[1] + "}"));

    }

    @Test
    public void streamUtills(){
//        anyMatch 는 스트림에 1개라도 match 되는 게 있으면 true 를 반환. ==쇼트 서킷
        if(menu.stream().anyMatch(x -> { System.out.println(x);return (x.getCalories() > 900);}))
        {
            System.out.println("is just one over 900 Over!");
        }

        System.out.println("====");
        // allMatch는 모든 요소가 match 일 경우, 재밌는 건 false를 만나면 바로 함수종료 == 쇼트 서킷
        if(menu.stream().allMatch(x -> { System.out.println(x);return (x.getCalories() > 900);}))
        {
            System.out.println("all 900 Over!");
        }

        // noneMatch는 모든 요소가 false 일 경우, 재밌는 건 true를 만나면 바로 함수종료 == 쇼트서킷
        if(menu.stream().noneMatch(x -> { System.out.println(x);return (x.getCalories() < 900);}))
        {
            System.out.println("all 900 Down!");
        }

        // findAny는 anyMatch와 똑같지만 Object를 return 한다. 문제는 찾을 수 없을 경우 Null 을 날릴 수 있는 데 이를 막고자 Optional을 씀
        Optional<Dish> result = menu.stream()
                .filter(x -> x.getCalories() > 9900)
                .findAny();
        System.out.println(result); // null 임으로, Optional.empty가 반환된다. 에러가 나지 않는다.


        // findFirst는 findAny와 완전 똑같지만, 병렬 실행에서는 첫번째 요소를 찾기 어렵기 때문에 잘 안쓴다고 함. findAny를 쓰라네.
        Optional<Dish> result2 = menu.stream()
                .filter(x -> x.getCalories() > 9900)
                .findFirst();
        System.out.println(result2); // null 임으로, Optional.empty가 반환된다. 에러가 나지 않는다.

    }


}