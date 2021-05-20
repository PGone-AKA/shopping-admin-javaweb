package com.example.test;

public class Welcome {
    private String admin;
    private int user_number;
    private int goods_number;
    private double day_account;
    private double total_account;
    private double total_profit;
    private int page_view;

    public double getTotal_profit() {
        return total_profit;
    }

    public void setTotal_profit(double total_profit) {
        this.total_profit = total_profit;
    }

    public Welcome() {
    }

    public Welcome(String admin, int user_number, int goods_number, double day_account, double total_account,double total_profit) {
        this.admin = admin;
        this.user_number = user_number;
        this.goods_number = goods_number;
        this.day_account = day_account;
        this.total_account = total_account;
        this.total_profit = total_profit;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getUser_number() {
        return user_number;
    }

    public void setUser_number(int user_number) {
        this.user_number = user_number;
    }

    public int getGoods_number() {
        return goods_number;
    }

    public void setGoods_number(int goods_number) {
        this.goods_number = goods_number;
    }

    public double getDay_account() {
        return day_account;
    }

    public void setDay_account(double day_account) {
        this.day_account = day_account;
    }

    public double getTotal_account() {
        return total_account;
    }

    public void setTotal_account(double total_account) {
        this.total_account = total_account;
    }
}
