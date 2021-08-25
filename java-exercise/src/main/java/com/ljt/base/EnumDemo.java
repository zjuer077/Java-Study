package com.ljt.base;

   enum Color
    {
        Black, RED, BLUE;

        // 构造函数
       public void Color()
        {
            System.out.println("Constructor called for : " + this);

        }
//        枚举跟普通类一样可以用自己的变量、方法和构造函数，构造函数只能使用 private 访问修饰符，所以外部无法调用。
//        枚举既可以包含具体方法，也可以包含抽象方法。 如果枚举类具有抽象方法，则枚举类的每个实例都必须实现它。

       public void colorInfo()
        {
            System.out.println("Universal Color : " + this);
        }
    }
public class EnumDemo {
    public static class Test
    {
        // 输出
        public static void main(String[] args)
        {
            Color c1 = Color.BLUE;
            System.out.println(c1);
            c1.colorInfo();
        }
    }
}

//    enum Color {
//        RED {
//            public String getColor() {//枚举对象实现抽象方法
//                return "红色";
//            }
//        },
//        GREEN {
//            public String getColor() {//枚举对象实现抽象方法
//                return "绿色";
//            }
//        },
//        BLUE {
//            public String getColor() {//枚举对象实现抽象方法
//                return "蓝色";
//            }
//        };
//
//        public abstract String getColor();//定义抽象方法
//    }
//
//    public static class Test {
//        public static void main(String[] args) {
//            for (Color c : Color.values()) {
//                System.out.print(c.getColor() + "、");
//            }
//        }
//    }
//}