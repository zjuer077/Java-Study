package com.ljt.AllClass;

public class Employee {
    String name;
    int age;
    String designation;
    double salary;
    public Employee(String name){
        this.name = name;
    }
    public void empAge(int empAge){
        age = empAge;
    }
    public void empDesignation(String empDesig){
        designation = empDesig;
    }
    public void empSalary(double empSalary){
        salary = empSalary;
    }

    public void printEmployee(){
        System.out.println("名字： "+ name);
        System.out.println("年龄： "+ age);
        System.out.println("职位： " + designation );
        System.out.println("收入： " + salary);


    }

    public static void main(String[] args) {

    Employee empOne = new Employee("ULINa");
    Employee empTwo = new Employee("MINGTIA");

        empOne.empAge(26);
        empOne.empDesignation("高级程序员");
        empOne.empSalary(1000);
        empOne.printEmployee();

        empTwo.empAge(27);
        empTwo.empDesignation("菜鸟程序员");
        empTwo.empSalary(500);
        empTwo.printEmployee();
    }

}