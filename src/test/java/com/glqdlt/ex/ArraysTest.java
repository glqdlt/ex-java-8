package com.glqdlt.ex;

import org.junit.Test;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class ArraysTest {

        // 재밌는 것은, 여기 someArray는 {0,1,2}의 값을 가리키는 레퍼런스에 고정되어있다.
        // 내가 Arrays.add 메소드에 someArray를 딥카피 하고 딥카피 된 배열 temp에 전달받았던 매개변수인 arr(==someArray로 기대)의 주소를 딥카피 된 배열로 바꾸면
        // 메소드 내부의 arr 은 레퍼런스 주소가 딥카피 temp를 가르키고, 실제로 반영된 데이터가 있지만
        // Arrays.add 밖으로 나왔을 때에는 여기 test 메소드 내부의 someArray라는 배열은 아직도 {0,1,2} 를 바라보고 있다.
        // 우리가 Arrays.add(args..) 안에서 someArray의 실질적인 값을 바꾼게 아니라, 딥 카피 한 temp 배열의 레퍼런스값을 덮어서 아규먼트로 들어온 배열이 temp를 바라보게 한 효과 밖에 안 된다.
    @Test
    public void arrayCopy() {
        int[] someArray = {0,1,2};
        System.out.println("someArray: "+someArray);
        Arrays.add(someArray,5);
        System.out.println("someArray: "+someArray);
    }

    @Test
    public void arrayCopy2(){
        // 인티저도 위의 경우와 같다.
        Integer[] someArray = {0,1,2};
        Arrays.addInteger(someArray,4);
        for (int i =0; i < someArray.length; i++){
            System.out.println(i);
        }
    }

    @Test
    public void arrayCopyToObject(){
        Apple[] apples = {new Apple("red",10),new Apple("blue",50)};

        Arrays.addObject(apples, new Apple("green",99));

        for(int i =0; i < apples.length ;i ++){
            System.out.println(apples[i].getColor());
        }

    }

}