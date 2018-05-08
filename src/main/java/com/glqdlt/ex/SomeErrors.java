package com.glqdlt.ex;

import lombok.Getter;

/**
 * Created By iw.jhun
 * On 2018-05-08
 */
@Getter
public enum SomeErrors {


    NOT_FOUND("404","페이지를 찾을 수 없음"),
    INTERNAL_ERROR("500","내부 시스템 에러");


    SomeErrors(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;
    private String message;

}
