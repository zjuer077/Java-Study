package com.ljt.base;

public class DataType {

    public static void main(String[] args) {

        // int
        int num = 10;
        System.out.println(num);

        // String
        String s = "hello,world,ljt,string";
        System.out.println(s.replace("hello", "hi"));

        String[] elements = s.split(",");

        // 练习一下 for 循环
        for (int i = 0; i < elements.length; i++) {
            System.out.println(elements[i]);
        }

        System.out.println("");

        for (String e : elements) {
            System.out.println(e);
        }

    }
}
