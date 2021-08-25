package com.ljt.AllClass;

public class Test {
    public static void main(String[] args) {
        int n = 4;
        int numbers [] = {10, 20, 30, 40, 50};

        for(int i = 0; i<= n; i++){
            System.out.print(numbers[i]);
            System.out.print(",");
            break;
//          continue;
        }
        System.out.print("\n");
        String [] names = {" James", "\n Hope", "\n Nothing", "\n Hello"};
        for(String name : names){
            System.out.print( name );
            System.out.print(",");
        }
    }
}

//
//    Java 增强 for 循环
//        Java5 引入了一种主要用于数组的增强型 for 循环。
//        Java 增强 for 循环语法格式如下:
//
//        for(声明语句 : 表达式)
//        {
//        //代码句子
//        }
//        声明语句：声明新的局部变量，该变量的类型必须和数组元素的类型匹配。其作用域限定在循环语句块，其值与此时数组元素的值相等。
//        表达式：表达式是要访问的数组名，或者是返回值为数组的方法。