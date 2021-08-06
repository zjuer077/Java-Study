package com.ljt.base;

public class Puppy {
    int puppyAge;
    public Puppy(String name){
        System.out.println("小狗的名字是 ： " + name);
    }

    /* public void setPuppyAge(int age) {
        puppyAge = age;
    } */

    public void setPuppyAge(int puppyAge) {
        this.puppyAge = puppyAge;
    }

    public int getAge() {
        System.out.println("小狗的年龄为 ： " + puppyAge );
        return puppyAge;
    }

    public static void main(String[] args) {
       /*创建对象*/
        Puppy myPuppy = new Puppy("tommy");
        /*通过方法来设定age */
        myPuppy.setPuppyAge( 2 );
        /*通过另外的方法获取age */
        myPuppy.getAge( );
        /*也可以像下面这样访问成员变量 */
        System.out.println("变量值 ： " + myPuppy.puppyAge );
    }
}
