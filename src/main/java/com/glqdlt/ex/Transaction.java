package com.glqdlt.ex;

/**
 * Created By iw.jhun
 * On 2018-05-03
 */
public class Transaction {

    private final Trader trader;
    private final int year;
    private final int vale;


    public Transaction(Trader trader, int year, int vale) {
        this.trader = trader;
        this.year = year;
        this.vale = vale;
    }

    public Trader getTrader() {
        return trader;
    }

    public int getYear() {
        return year;
    }

    public int getVale() {
        return vale;
    }
}
