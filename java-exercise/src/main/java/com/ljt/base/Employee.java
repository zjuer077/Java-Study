package com.ljt.base;
import java.io.*;
public class Employee {
    String name;
    int age;
    String designation;
    double salary;
    //Employee 类的构造器
    public  Employee(String name){
        this.name = name;
    }
    // 设置name值
    public void emAge(int emAge) {
        this.age = emAge;
    }
    /*设置 age值*/

    public void empDesignation(String empDesig){
        designation = empDesig;
    }
    /*设置designation的值*/

    public void empSalary(double empSalary){
        salary = empSalary;
    }
    /* 设置salary的值*/
    /*打印信息*/
    public void printEmployee(){
        System.out.println("名字：" + name);
        System.out.println("年龄：" + age);
        System.out.println("职位：" + designation);
        System.out.println("薪水：" + salary);

    }

}
