package com.ljt.base;

public class BigOrSmall {
    public static void main(String[] args) {
        max ( 5, 10);
    }
    public static void max(int num, int num2) {
// 一个void方法的调用一定是一个语句。 所以，它被在main方法第三行以语句形式调用。就像任何以分号结束的语句一样。
        int result;
        if (num > num2)
            result = num;
        else
            result = num2;
        System.out.println(result);
    }

}
