package com.glqdlt.ex;

/**
 * Created By iw.jhun
 * On 2018-04-19
 */
public class YelloApple extends Apple {

    private String option;

    public YelloApple(String color, int weight, String option) {
        super(color, weight);
        this.option = option;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

}
