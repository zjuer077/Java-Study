package com.ljt.Abstract;

public class AbstractDemo {
    public static void main(String[] args) {
        Salary s = new Salary( "Mohd Mohtashim", "Ambehata, UP", 3, 3600);
        Employee e = new Salary("George W.", "Houston, TX", 43, 2400);
        System.out.println("\n Call mailCheck using Employee Reference--");
        s.mailCheck();

        System.out.println("\n Call mailCheck using Employee reference--");
        e.mailCheck();
    }
}
