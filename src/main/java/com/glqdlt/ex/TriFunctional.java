package com.glqdlt.ex;

/**
 * Created By iw.jhun
 * On 2018-04-19
 */
@FunctionalInterface
public interface TriFunctional<T,U,V,R> {
//    T U V 는 R이란 객체의 생성자와 apply가 매핑되서 실행될거고, 생성된 객체는 apply의 return 이 생성된 R 객체임을 유추할수있음.
    R apply(T t, U u, V v);
}
