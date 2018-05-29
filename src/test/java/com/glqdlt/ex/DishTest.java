package com.glqdlt.ex;

import com.sun.org.apache.xpath.internal.SourceTree;
import org.junit.Test;

import java.util.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-20
 */
public class DishTest {


    private List<Dish> menu;

    public DishTest() {
        setupData();
    }

    private void setupData() {
//        for (int i = 0; i < 999; i++) {
//            menu.add(new Dish("some-dish" + i, (i % 3 == 0), (int) (Math.random() * 1000) + 1, ((i % 3 == 0) ? Dish.Type.MEAT : Dish.Type
//                    .FISH)));
//
//        }

//         이 얼마나 아름다운가..,

        menu = IntStream.rangeClosed(0, 999).boxed().map(x -> new Dish("some-dish" + x, (x % 3 == 0), (int) (Math.random() * 1000) + 1, (
                (x % 3 == 0) ? Dish.Type.MEAT : Dish.Type
                        .FISH))).collect(toList());
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
                            System.out.println("!!" + y);
                            return ((y + x) % 3 == 0);
                        })
                        .map(y -> {
                            System.out.println(y + "yy!!");
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
    public void streamUtills() {
//        anyMatch 는 스트림에 1개라도 match 되는 게 있으면 true 를 반환. ==쇼트 서킷
        if (menu.stream().anyMatch(x -> {
            System.out.println(x);
            return (x.getCalories() > 900);
        })) {
            System.out.println("is just one over 900 Over!");
        }

        System.out.println("====");
        // allMatch는 모든 요소가 match 일 경우, 재밌는 건 false를 만나면 바로 함수종료 == 쇼트 서킷
        if (menu.stream().allMatch(x -> {
            System.out.println(x);
            return (x.getCalories() > 900);
        })) {
            System.out.println("all 900 Over!");
        }

        // noneMatch는 모든 요소가 false 일 경우, 재밌는 건 true를 만나면 바로 함수종료 == 쇼트서킷
        if (menu.stream().noneMatch(x -> {
            System.out.println(x);
            return (x.getCalories() < 900);
        })) {
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


    @Test
    public void 요약연산() {

        Optional<Dish> some = menu.stream().peek(x -> System.out.println(x.toString())).max(Comparator.comparingInt(x -> x.getCalories()));
        System.out.println(some.get().getCalories());

        double ss = menu.stream().collect(averagingInt(Dish::getCalories));

        IntSummaryStatistics sss = menu.stream().collect(summarizingInt(Dish::getCalories));


        System.out.println(ss);
        System.out.println(sss);

//        String menuList = menu.stream().map(Dish::getName).collect(joining());
//        딜리미터 오버로드 메소드
        String menuList = menu.stream().map(Dish::getName).collect(joining(", "));
//        System.out.println(menuList);

//        a1과 a2를 더해서 totalSum 효과를 내는 reduce
        int someTotal = menu.stream().map(Dish::getCalories).reduce(0, (a1, a2) -> a1 + a2);

//        위 someTotal과 가독성 차이를 보자.. 어떤게 나을까?
        int anotherSomeTotal = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);


        System.out.println(someTotal);

//        a1과 a2 중에 가장 큰 인자를 찾는 reduce
        Optional<Integer> maxCalories = menu.stream().map(Dish::getCalories).reduce((a1, a2) -> a1 > a2 ? a1 : a2);
        System.out.println(maxCalories.get());

        String someww = "qwe,qwe,";

        Optional<Integer> nullOptional = Optional.empty();
        System.out.println(nullOptional.orElse(9));


//        리듀싱연산과 콜렉트 연산이 비슷하고 같은 기능처럼 쓸 수 있지만, 리듀싱은 어렵지만 콜렉트가 병렬에서 처리가 가능하다.
    }

    @Test
    public void 그룹화() {
        Map<Dish.Type, List<Dish>> some = menu.stream().collect(groupingBy(Dish::getType));
//        System.out.println(some.get(Dish.Type.MEAT));
//        System.out.println("=======");
//        System.out.println(some.get(Dish.Type.FISH));

        Map<String, List<Dish>> some2 = menu.stream().collect(groupingBy(item -> {
            if (item.getCalories() < 400) {
                return "normal";
            } else {
                return "pig";
            }
        }));

        System.out.println(some2.get("normal"));
    }

    @Test
    public void N수준_그룹화() {
//        2개의 복합 그룹핑. 첫번째로 type별로 나누고, 나뉜 type안에서도 칼로리 수치에 따라 돼지냐 노말이냐로 나눔.
        Map<Dish.Type, Map<String, List<Dish>>> manyGroup = menu.stream().collect(groupingBy(Dish::getType, groupingBy(item ->
        {
            if (item.getCalories() < 400) {
                return "normal";
            } else {
                return "pig";
            }
        })));

        System.out.println(manyGroup.get(Dish.Type.FISH).get("normal"));
    }

    @Test
    public void 서브그룹_데이터_수집(){

//        MEAT와 FISH 그룹으로 나누고, 거기서 maxBy를 통해 가장 높은 칼로리를 가진 DIsh optional을 넣음
        Map<Dish.Type, Optional<Dish>> some = menu.stream().collect(groupingBy(Dish::getType, maxBy(Comparator.comparingInt(Dish::getCalories))));

        Map<Dish.Type, Dish> some2 = menu.stream().collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparingInt(Dish::getCalories)),
                Optional::get)));
//        some.forEach((x,y) -> System.out.println(y.get()));

        System.out.println(some2.get(Dish.Type.FISH));

    }

    @Test
    public void 분할_함수(){
        Map<Boolean, List<Dish>> some = menu.stream().collect(partitioningBy(Dish::isVegetarian));
        some.forEach((x,y) -> System.out.println(x+" size:"+y.size()));
    }



}