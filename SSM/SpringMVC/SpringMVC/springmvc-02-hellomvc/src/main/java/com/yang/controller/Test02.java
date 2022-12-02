package com.yang.controller;

public class Test02 {
    static void test(int b[]) {
        b[b[1]]++;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3, 4, 5};
        test(a);
        System.out.println(a[1] + a[2]);
    }
}
