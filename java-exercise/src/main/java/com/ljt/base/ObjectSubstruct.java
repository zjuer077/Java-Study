package com.ljt.base;
//class 的构造方法，在创建一个对象的时候，至少要调用一个构造方法。
public class ObjectSubstruct {

    public ObjectSubstruct(String name){
        //这个构造器仅有一个参数：name
        /*此处调用了构造方法 public ObjectSubstruct*/
        System.out.println("小狗的名字是 ：" + name);
    }

    public static void main(String[] args) {
        //下面的语句将创建一个Puppy对象
        ObjectSubstruct myObjectSubstruct = new ObjectSubstruct("June");
    }
}
