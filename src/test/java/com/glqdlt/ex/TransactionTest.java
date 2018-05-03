package com.glqdlt.ex;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Created By iw.jhun
 * On 2018-05-03
 */
public class TransactionTest {

    List<Transaction> transactions = new ArrayList<>();

    public TransactionTest() {

        transactions.add(new Transaction(new Trader("some", "korea"), 2011, 9993));
        transactions.add(new Transaction(new Trader("mike", "korea"), 2012, 99));
        transactions.add(new Transaction(new Trader("yuna", "japan"), 2013, 999));
        transactions.add(new Transaction(new Trader("nilson", "america"), 2011, 9996));
        transactions.add(new Transaction(new Trader("swake", "america"), 2011, 99976));
    }

    @Test
    public void should2011TranstionSorted() {

        // 오름차순으로 정렬시에는 reversed() 를 없앤다.
        List<Transaction> sortedTrans = transactions
                .stream()
                .filter(x -> (x.getYear() == 2011))
//                .sorted(Comparator.comparing(x -> x.getVale()))
//                .sorted(Comparator.comparingInt(x -> x.getVale()))
//                아래는 내림차순을 위해 reversed 한다, 참고로 메서드 레퍼런스가 아니면 reversed가 안먹는다.
                .sorted(Comparator.comparing(Transaction::getVale).reversed())
                .collect(toList());
        sortedTrans.forEach(x -> System.out.println(x.getYear()+":"+x.getVale()));

        // 중복되지 않은 transctions 의 나라이름들
        List<String> soloCity = transactions.stream().map(x -> x.getTrader().getCity()).distinct().collect(toList());
        soloCity.forEach(System.out::println);

        // 한국에 거주하는 trader 리스트 출력
        List<Trader> koreaTrader = transactions.stream().filter(x -> x.getTrader().getCity().equals("korea")).map(Transaction::getTrader)
                .collect(toList());

        koreaTrader.forEach(x -> System.out.println(x.getName()));
    }

    @Test
    public void shouldMapToIntMax(){
        int sumTrans = transactions.stream().mapToInt(Transaction::getVale).sum();
        int maxTrans = transactions.stream().map(Transaction::getVale).reduce(0, (x,y) -> x+y);
        System.out.println(sumTrans);
        System.out.println(maxTrans);


        // 이 경우 IntStream으로만 받을 수 있다..
        IntStream sorted = transactions.stream().mapToInt(Transaction::getVale).sorted();

        //만약에 sumTrans처럼 int 특화 스트림을 썻을 경우, int 말고 다른 객체를 받고 싶을 땐 어떻게해야할까? 아래처럼하면됨.
        List<Integer> sortedValues = transactions.stream().mapToInt(Transaction::getVale).sorted().boxed().collect(toList());

        sortedValues.forEach(System.out::println);

        OptionalInt max = transactions.stream().mapToInt(Transaction::getVale).max();

        // null 일 경우 default 값을 1로 넣는다. 즉, transactions 리스트 객체가 비어있을 경우엔 max는 Optional이라 null은 아니지만.. 실제 값을 getAsInt 때리면 empty 값이 나올 수 있다.
        // 이걸 막고자 하는게 orElse이다.

        max.orElse(1);

        System.out.println(max.getAsInt());

    }

    @Test
    public void shoudRangeClosed(){
        IntStream.rangeClosed(1,100).filter(n -> n % 2 ==0).forEach(System.out::println);
    }


}