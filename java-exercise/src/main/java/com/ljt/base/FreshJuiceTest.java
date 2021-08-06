package com.ljt.base;

class FreshJuice{
    enum FreshJuiceSIZE{ SMALL, MEDIUM, LARGE}
    FreshJuiceSIZE size;
}
public class FreshJuiceTest {
    public static void main(String[] args) {
        FreshJuice juice = new FreshJuice();
        juice.size = FreshJuice.FreshJuiceSIZE.MEDIUM ;
    }
}
