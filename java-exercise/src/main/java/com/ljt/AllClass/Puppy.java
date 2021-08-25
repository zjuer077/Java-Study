package com.ljt.AllClass;

public class Puppy {
//    public Puppy(){
//
//    }
    int puppyAge;
    public Puppy(String name){
    System.out.println("小狗的名字是： " + name);
    }

    public void setAge( int age ){
        puppyAge = age;
    }

    public int getAge(){
        System.out.println("小狗的年龄是： " + puppyAge );
        return puppyAge;
    }

    public static void main(String[] args) {
        Puppy myPuppy = new Puppy("hello");
        myPuppy.setAge(2);
        myPuppy.getAge();
        System.out.println("变量值 ： " + myPuppy);

    }
}
