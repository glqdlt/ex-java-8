package com.glqdlt.ex.utill;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class PowerfulLogger implements  Logger {
    @Override
    public void write(String msg) {
        System.out.println("Power : "+msg);
    }
}
