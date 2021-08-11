package com.ljt.base;

public class PrintArray {
    public static void main(String[] args) {
        printArray(new int[]{0,2,6,7});
    }
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i ++) {
            System.out.println(array[i]+ "");}
    }
}
