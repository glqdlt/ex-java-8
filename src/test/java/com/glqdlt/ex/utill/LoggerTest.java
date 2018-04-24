package com.glqdlt.ex.utill;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class LoggerTest {

    @Test
    public void shouldMakerPowerfulLogger(){
        LogUtill logUtill = new LogUtill(new PowerfulLogger());
        logUtill.logging("wow");
    }

}