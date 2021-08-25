package com.ljt.rewrite;

import com.sun.security.auth.UnixNumericGroupPrincipal;

public class VirtualDemo {
    public static void main(String[] args) {
        Employee e = new Salary("员工 B", "上海", 2, 2400.00);
        Salary s = new Salary("员工 A", "北京", 3, 3600.00);

        System.out.println("\n使用Employee 的引用调用mailCheck--");
        e.mailCheck();
        System.out.println("使用Salary 的引用调用 mailCheck --");
        s.mailCheck();

        Salary r = new PayBack("员工C", "name",5, 2544.00, 424);
        PayBack u = new PayBack("员工D", "name",50, 2594.00, 425);
        r.mailCheck();
        u.mailCheck();

        //e 是 Employee 的引用，但引用 e 最终运行的是 Salary 类的 mailCheck() 方法。
    }
}

//        实例中，实例化了两个 Salary 对象：一个使用 Salary 引用 s，另一个使用 Employee 引用 e。
//
//        当调用 s.mailCheck() 时，编译器在编译时会在 Salary 类中找到 mailCheck()，执行过程 JVM 就调用 Salary 类的 mailCheck()。
//
//        e 是 Employee 的引用，但引用 e 最终运行的是 Salary 类的 mailCheck() 方法。
//
//        在编译的时候，编译器使用 Employee 类中的 mailCheck() 方法验证该语句， 但是在运行的时候，Java虚拟机(JVM)调用的是 Salary 类中的 mailCheck() 方法。
//
//        以上整个过程被称为虚拟方法调用，该方法被称为虚拟方法。