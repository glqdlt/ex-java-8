package com.glqdlt.ex;

import javax.xml.transform.Source;

/**
 * Created By iw.jhun
 * On 2018-04-24
 */
public class Arrays {


    public static void add(int[] arr, int i) {
        System.out.println("someArray arr(arg): " + arr);
        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
        arr[arr.length - 1] = i;
        System.out.println("temp: " + temp+", val = "+temp[temp.length-1]);
        System.out.println("arr:" + arr+", val = "+arr[arr.length-1]);

    }

    public static void addInteger(Integer[] arr, Integer i) {
        Integer[] temp = new Integer[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
        arr[arr.length - 1] = i;
    }

    public static void addObject(Object[] arr, Object i) {
        Object[] temp = new Object[arr.length + 1];
        System.arraycopy(arr,0,temp,0,arr.length);
        arr = temp;
        arr[arr.length -1 ]= i;
    }

}
