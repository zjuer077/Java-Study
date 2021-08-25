package com.ljt.AllClass;

public class TwiceChat {
    public static void main(String[] args) {
    String[][] s =  new String[3][2];
//    s[0] = new String[2];
//    s[1] = new String[3];
    s[0][0] = new String("Good");
    s[0][1] = new String("luck");
    s[1][0] = new String("to");
    s[1][1] = new String("you");
    s[2][0] = new String("!");
    s[2][1] = new String("!");

        for(int i = 0; i < 3; i++ ) {
            for (int j = 0; j < 2; j++) {
                System.out.println(s[i][j]);
            }
        }
}
}