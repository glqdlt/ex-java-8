package com.glqdlt.ex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Type;

/**
 * Created By iw.jhun
 * On 2018-04-20
 */


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Dish {

    private String name;
    private boolean vegetarian;
    private Integer calories;
    private Type type;

    public enum Type{
        MEAT,FISH
    }

}
