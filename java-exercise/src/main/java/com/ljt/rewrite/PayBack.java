package com.ljt.rewrite;

public class PayBack extends Salary{
    public double payback;
    public PayBack(String name, String address, int number, double salary, double payback) {
        super(name, address, number, salary);
        setPayback(payback);
    }
    public double getPayback(){
        return payback/12;
    }
    public void setPayback(double newPayBack){
        if (newPayBack >= 0.0)
        payback = newPayBack;
    }
    public void mailCheck(){
        System.out.println("邮寄支票给我： " + this.name + " " + this.address + " 工资为：" + getSalary() + " payback为：" + getPayback());
    }
}
