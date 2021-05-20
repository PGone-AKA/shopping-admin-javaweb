package com.example.test;

public class Goods {
    private int gid;
    private String gname;
    private double bid;
    private double price;
    private int stock;

    public Goods(int gid, String gname, double bid, double price, int stock) {
        this.gid = gid;
        this.gname = gname;
        this.bid = bid;
        this.price = price;
        this.stock = stock;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
