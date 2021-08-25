package com.ljt.base;

/* import java.util.Scanner;

public class ScannerClass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接受数据
        // next方式接受字符串
        System.out.println("next方式接受：");
        // 判断是否还有输入
        //if(scan.hasNext()){
            if(scan.hasNextLine()){
        String str1 = scan.nextLine();
            System.out.println("输入的数据为：" +str1);
        }
        scan.close();
    }
}
*/
//next():
//1、一定要读取到有效字符后才可以结束输入。
//2、对输入有效字符之前遇到的空白，next() 方法会自动将其去掉。
//3、只有输入有效字符后才将其后面输入的空白作为分隔符或者结束符。
//next() 不能得到带有空格的字符串。

//nextLine()：
//1、以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符。
//2、可以获得空白。
//如果要输入 int 或 float 类型的数据，在 Scanner 类中也有支持，但是在输入之前最好先使用 hasNextXxx() 方法进行验证，再使用 nextXxx() 来读取。

/*
import java.util.Scanner;

public class ScannerClass{
    public static void main(String[] args) {
        System.out.println("请输入数字：");
        Scanner scan = new Scanner(System.in);
        double sum = 0;
        int m = 0;
        while (scan.hasNextDouble()){
            double x = scan.nextDouble();
            m = m + 1;
            sum = sum + x;
        }
        System.out.println(m + "个数的和为" + sum);
        System.out.println(m + "个数的平均值是" + (sum / m));
        scan.close();
    }
}
//输入多个数字，并求其总和与平均数，每输入一个数字用回车确认，通过输入非数字来结束输入并输出执行结果

*/

public class ScannerClass{
    public static void main(String args[]){
        int a[] = new int[2];
        try{
            System.out.println("Access element three :" + a[3]);
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception thrown  :" + e);
        }
        finally{
            a[0] = 6;
            System.out.println("First element value: " +a[0]);
            System.out.println("The finally statement is executed");
        }
    }
}
