package com.example.databindingdemo;

public class Test {

    public static void main(String[] args) {
        int i = 11;
        set(i);
        System.out.println(i);
    }

    public static void set(int i) {
        i = 10;
    }
}
