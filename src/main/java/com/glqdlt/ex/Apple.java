package com.glqdlt.ex;

import java.awt.*;

/**
 * Created By iw.jhun
 * On 2018-04-13
 */
public class Apple {

    private String color;
    private int weight;

    public Apple() {
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String s) {
        this.color = s;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }
}
