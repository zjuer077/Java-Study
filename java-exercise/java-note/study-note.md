
**20210805**

-- 查看当前分支项目状态
git status

-- 把工作区的文件加入到 index 区域
git add .

-- 把暂存区文件放入本地仓库(.init)
git commit -m ""

-- 把本地仓库内存更新传到远程仓库
git push

```java
public class Demo {
    public static void main(String[] args) {
        System.out.println("hello jintaoli");
    }
}
```
**20210817**

类别	关键字	说明

**访问控制**	
private	私有的
protected	受保护的
public	公共的
default	默认

**类、方法和变量修饰符**	
abstract	声明抽象
class	类
extends	扩充,继承
final	最终值,不可改变的
implements	实现（接口）
interface	接口
native	本地，原生方法（非 Java 实现）
new	    新,创建
static	静态
strictfp	严格,精准
synchronized	线程,同步
transient	短暂
volatile	易失

**程序控制语句**	
break	跳出循环
case	定义一个值以供 switch 选择
continue	继续
default	默认
do	    运行
else	否则
for	    循环
if	    如果
instanceof	实例
return	返回
switch	根据值选择执行
while	循环

**错误处理**	
assert	断言表达式是否为真
catch	捕捉异常
finally	有没有异常都执行
throw	抛出一个异常对象
throws	声明一个异常可能被抛出
try	    捕获异常

**包相关**	
import	引入
package	包

**基本类型**	
boolean	布尔型
byte	字节型
char	字符型
double	双精度浮点
float	单精度浮点
int	    整型
long	长整型
short	短整型

**变量引用**	
super	父类,超类
this	本类
void	无返回值

**保留关键字**	
goto	是关键字，但不能使用
const	是关键字，但不能使用
null	空

**构造方法**

每个类都有构造方法。如果没有显式地为类定义构造方法，Java 编译器将会为该类提供一个默认构造方法。
在创建一个对象的时候，至少要调用一个构造方法。构造方法的名称必须与类同名，一个类可以有多个构造方法。
下面是一个构造方法示例：

**创建对象**

对象是根据类创建的。在Java中，使用关键字 new 来创建一个新的对象。创建对象需要以下三步：

**声明**：声明一个对象，包括对象名称和对象类型。
**实例化**：使用关键字 new 来创建一个对象。
**初始化**：使用 new 创建对象时，会调用构造方法初始化对象。

```java
package com.ljt.AllClass;

public class Puppy {
//    public Puppy(){
//
//    }
public Puppy(String name){
System.out.println("小狗的名字是： " + name);
}

    public static void main(String[] args) {
        Puppy c = new Puppy("hello");
    }
}
```

```java
public class Puppy {
//    public Puppy(){
//
//    }
    int puppyAge;
    public Puppy(String name){
        // 这个构造器仅有一个参数：name
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
```
mployee 类有四个成员变量：name、age、designation 和 salary。该类显式声明了一个构造方法，该方法只有一个参数。
```java
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
```
**Java语言支持一些特殊的转义字符序列**
符号	字符含义
\n	换行 (0x0a)
\r	回车 (0x0d)
\f	换页符(0x0c)
\b	退格 (0x08)
\0	空字符 (0x0)
\s	空格 (0x20)
\t	制表符
\"	双引号
\'	单引号
\\	反斜杠
\ddd	八进制字符 (ddd)
\uxxxx	16进制Unicode字符 (xxxx)

类变量也称为静态变量，在类中以 static 关键字声明，但必须在方法之外。
无论一个类创建了多少个对象，类只拥有类变量的一份拷贝。
静态变量除了被声明为常量外很少使用，静态变量是指声明为 public/private，final 和 static 类型的变量。静态变量初始化后不可改变。
静态变量储存在静态存储区。经常被声明为常量，很少单独使用 static 声明变量。
静态变量在第一次被访问时创建，在程序结束时销毁。
与实例变量具有相似的可见性。但为了对类的使用者可见，大多数静态变量声明为 public 类型。
默认值和实例变量相似。数值型变量默认值是 0，布尔型默认值是 false，引用类型默认值是 null。变量的值可以在声明的时候指定，也可以在构造方法中指定。此外，静态变量还可以在静态语句块中初始化。
静态变量可以通过：ClassName.VariableName的方式访问。
类变量被声明为 public static final 类型时，类变量名称一般建议使用大写字母。如果静态变量不是 public 和 final 类型，其命名方式与实例变量以及局部变量的命名方式一致。

**Number & math**

Number & Math 类方法
下面的表中列出的是 Number & Math 类常用的一些方法：

序号	方法与描述
1	xxxValue() 将 Number 对象转换为xxx数据类型的值并返回。
2	compareTo() 将number对象与参数比较。
3	equals() 判断number对象是否与参数相等。
4	valueOf() 返回一个 Number 对象指定的内置数据类型
5	toString() 以字符串形式返回值。
6	parseInt() 将字符串解析为int类型。
7	abs() 返回参数的绝对值。
8	ceil() 返回大于等于( >= )给定参数的的最小整数，类型为双精度浮点型。
9	floor() 返回小于等于（<=）给定参数的最大整数 。
10	rint() 返回与参数最接近的整数。返回类型为double。
11	round() 它表示四舍五入，算法为 Math.floor(x+0.5)，即将原来的数字加上 0.5 后再向下取整，所以，Math.round(11.5) 的结果为12，Math.round(-11.5) 的结果为-11。
12	min() 返回两个参数中的最小值。
13	max() 返回两个参数中的最大值。
14	exp() 返回自然数底数e的参数次方。
15	log() 返回参数的自然数底数的对数值。
16	pow() 返回第一个参数的第二个参数次方。
17	sqrt() 求参数的算术平方根。
18	sin() 求指定double类型参数的正弦值。
19	cos() 求指定double类型参数的余弦值。
20	tan() 求指定double类型参数的正切值。
21	asin() 求指定double类型参数的反正弦值。
22	acos() 求指定double类型参数的反余弦值。
23	atan() 求指定double类型参数的反正切值。
24	atan2() 将笛卡尔坐标转换为极坐标，并返回极坐标的角度值。
25	toDegrees() 将参数转化为角度。
26	toRadians() 将角度转换为弧度。
27	random() 返回一个随机数。

