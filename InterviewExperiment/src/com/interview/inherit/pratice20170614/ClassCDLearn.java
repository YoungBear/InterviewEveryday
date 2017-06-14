package com.interview.inherit.pratice20170614;

/**
 * Created by ysx on 2017/6/14.
 * 题目链接：
 * https://www.nowcoder.com/questionTerminal/6080d0e94cee4ce5952064f96f2b1650
 */
public class ClassCDLearn {
    public static void main(String[] args) {
        ClassC classC = new ClassC();
        System.out.println("classC.TAG: " + classC.TAG + ", classC.age: " + classC.age + ", classC.name: " + classC.name);

        //发生隐藏的时候，声明类型是什么类，就调用对应类的属性或方法，而不会发生动态绑定
        //方法隐藏只有一种形式，就是父类和子类存在相同的静态方法
        System.out.println("*************************************");
        ClassC classC1 = new ClassD();
        System.out.println("classC1.TAG: " + classC1.TAG + ", classC1.age: " + classC1.age + ", classC1.name: " + classC1.name);

        //子类实例变量/静态变量可以隐藏父类中的属性
        System.out.println("*************************************");
        ClassD classD = new ClassD();
        System.out.println("classD.TAG: " + classD.TAG + ", classD.age: " + classD.age + ", classD.name: " + classD.name);

        //强制类型转换，被隐藏的属性，在子类被强制转换成父类后，访问的是父类中的属性
        System.out.println("*************************************");
        ClassC classC2 = (ClassC) classD;
        System.out.println("classC2.TAG: " + classC2.TAG + ", classC2.age: " + classC2.age + ", classC2.name: " + classC2.name);
    }
}
