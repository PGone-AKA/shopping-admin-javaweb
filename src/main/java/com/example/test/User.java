package com.example.test;

public class User {
    private int id;
    private String name;
    private String pd;
    private String sex;
    private int age;
    private long phone;
    private double balance;
    private String date;

    public User() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User(String name, String pd, String sex, int age, long phone, double balance) {
        this.name = name;
        this.pd = pd;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
    }

    public User(int id, String name, String pd, String sex, int age, long phone, double balance, String date) {
        this.id = id;
        this.name = name;
        this.pd = pd;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
        this.date = date;
    }

    public User(int id, String name, String pd, String sex, int age, long phone, double balance) {
        this.id = id;
        this.name = name;
        this.pd = pd;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPd() {
        return pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
