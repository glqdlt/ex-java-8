package com.glqdlt.ex;

import org.junit.Test;

/**
 * Created By iw.jhun
 * On 2018-04-17 , 오전 11:52
 */
public class ThreadInLamdaTest {

    // 이 테스트는 @test 스레드 외의 다른 스레드에 할당 되어 동작되므로 해당 워커 스레드가 동작중이지만, @test 스레드는 종료함으로 200번까지 console에 로그가 찍히지 않는다.
    @Test
    public void someTest() {
        Thread thread = new Thread(() ->
            {
                for (int i = 0; i < 200; i++) {
                    System.out.println(i);
                }
            }
        );

        Thread thread2 = new Thread(() ->
            {

                for(int i =0; i <100; i++){
                    System.out.println(i+"haha");
                }

            }
        );

        thread.start();
        thread2.start();
    }
}
