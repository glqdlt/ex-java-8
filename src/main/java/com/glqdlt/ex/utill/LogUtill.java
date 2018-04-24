package com.glqdlt.ex.utill;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */

// DI에서 자주 쓰던 전략패턴. 자주 쓰던 것이라 반갑다.
    // 전략 패턴의 장점은 레이어 사이에 구현체에 대해 신경안써도 되는 장점이 있다.
    // 또한 동적으로 구현체를 바꿔 끼울 수 있는 점이 있다.
//strategy  pattern
public class LogUtill {

    private Logger logger;

    public LogUtill(Logger logger) {
        this.logger = logger;
    }

    public void logging(String msg){
        this.logger.write(msg);
    }

}
