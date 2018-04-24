package com.glqdlt.ex;

import java.lang.reflect.Array;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class Arrays {


//     TODO 아래는 컴파일 되지 않는다 이유는 아래와 같다.

    //    이것이 불가능한 이유는 Java가 Generic을 컴파일러 수준에서만 구현하고 각 클래스에 대해 하나의 클래스 파일 만 생성되기 때문입니다. 이를 유형 삭제 라고 합니다.
//    런타임시 컴파일 된 클래스는 동일한 바이트 코드로 모든 용도를 처리해야합니다. 따라서 new T[capacity]어떤 유형을 인스턴스화해야하는지 전혀 알 수 없습니다.
//    public static <E> E[] addToObject(E[] arr, E i) {
//        E[] temp;
//        if (arr instanceof Object[]) {
//            temp = new E[arr.length + 1];
//        }
//        if (arr instanceof Integer[]) {
//            temp = new E[arr.length + 1];
//        }
//
//
//        System.arraycopy(arr, 0, temp, 0, arr.length);
//        temp[temp.length - 1] = i;
//        return temp;
//    }

    public static <E> E[] addToObject(E[] arr, E val) {
        // type check 경고가 뜬다.
        E[] temp = (E[]) new Object[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        temp[temp.length - 1] = val;
        return temp;
    }


}
