package com.ljt.base;

public class EmployeeTest {
    public static void main(String[] args) {
         Employee empOne = new Employee("RUNOOB1");
         Employee empTwo = new Employee("RUNOOB2");

         empOne.emAge(26);
         empOne.empDesignation("高级程序员");
         empOne.empSalary(1000);
         empOne.printEmployee();

         empTwo.emAge(21);
         empTwo.empDesignation("菜鸟程序员");
         empTwo.empSalary(500);
         empTwo.printEmployee();


    }
}
