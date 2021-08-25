package com.ljt.shangxuetang;

import sun.awt.geom.AreaOp;

public class Test {
    public static void main(String[] args) {
//        int a = 6;
//        int b = 5 ;
//        int c = 16;
//        int d = c >> 1;
//        System.out.println(a | b);
//        System.out.println(c);
//        System.out.println(d);
//        boolean b1 = 1 > 5 && 2 > 5/0;
//        System.out.println(b1);
//
//        int score = 5;
//        String type = score < 9?"不及格": "及格";
//        System.out.println(type);
//
//        if(score<2){
//            System.out.println(("不及格"));
//
//        }else{
//            System.out.println("及格");
//        }
//
//
//        double d = Math.random();
//        System.out.println(d);
//
//        int i = (int)(6*Math.random()+1);
//        System.out.println(i);
//        if(i>=4){
//
//            System.out.println("小");
//
//        }else {
//
//            System.out.println("小小小");
//        }


        int month = (int)(1+12*Math.random());
        switch (month){
            case 1:
                System.out.println("一月份了");
                break;
            case 2:
                System.out.println("二月份了");
                break;
        }

        int i= 1;
        int sum = 0;

        while (i<=100){
            sum = sum +i;
            i ++;
        }
        System.out.println(sum);


        int sum2 = 0;
        for(int j = 0; j <= 100; j++){
            sum2 = sum2 + j;

        }
        System.out.println(sum2);


        for(int h = 1; h <=5 ; h ++){
            for(int m = 1 ; m <= 5; m ++){
                System.out.print(h + "\t");
            }
            System.out.println();
        }

        for(int n = 1; n <= 9; n ++){
            for(int p = 1; p <= n; p ++){
                System.out.print(p + "*" + n + "=" + (p * n) + "\t");
            }
            System.out.println();
        }

        int count = 0;
        for(int r = 1; r <= 1000; r ++){
            if(r % 5 == 0){
                System.out.print(r +"\t");
                count ++;
            }
            if(count == 5){
                System.out.println();
                count = 0;
            }
        }
    }
}
