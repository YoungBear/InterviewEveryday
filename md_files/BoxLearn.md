# Java包装类传递形参

先看一段程序：

```
package com.interview.bytelearn;

/**
 * 原题链接：https://www.nowcoder.com/questionTerminal/1bab09264a1c4528aa60ee9bca5f0976
 */

public class Test2 {

    public static void main(String[] args) {
        test();

    }

    /**
     * add函数内实现++操作，会自动拆包成byte值传递类型，所以原Byte的值不会变
     * */
    public static void add(Byte b) {
        b = b++;
    }

    public static void test() {
        Byte a = 127;
        Byte b = 127;

        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}

```

运行函数test时，正确的输出结果是：-128 127。

首先Byte的取值范围是-128 ~ 127。

调用add(++a)，执行++a时，a溢出，a变成了-128。然后传递到函数add()里，注意，虽然说形参是对象Byte类型，但是由于Byte是包装类，实际上类似于基本数据类型，执行函数add时，b不会改变，但是，即使b的值改变了，但是它也不会影响实参a的值，所以执行完成之后，a还是-128。

调用add(b)时，显然b的值不会变，即add函数执行完成之后，b还是127。

再看一段更明显的代码：

在函数test里边对Byte类型的形参b重新赋值，执行完test函数后，b的值仍旧是127，即这里是值传递，函数add并不会改变b的值。
```
package com.interview.boxlearn;

public class Test3 {

    public static void main(String[] args) {

        Byte b = 127;
        test(b);
        System.out.println(b);//输出为127

    }

    public static void test(Byte b) {
        Byte c = 10;
        b = c;
    }
}
```

对应String也有这样的实例：由于String是final类型的，所以每次给一个String变量赋值，都会new一个新的对象。而传递一个参数给函数，其在函数里边改变值，对函数外边的变量没有影响。

```
public class StringTest {
    public static void main(String[] args) {

        String str = "main";
        test(str);
        System.out.println(str);//输出为main
        test1(str);
        System.out.println(str);//输出为main
    }

    public static void test(String s) {
        s = "in the function";
    }

    public static void test1(String s) {
        s = s + "123";
    }
}
```

同样，Integer也一样：

```
public class IntegerTest {

    public static void main(String[] args) {

        Integer a = 1;
        test(a);
        System.out.println(a);//输出为1
        test1(a);
        System.out.println(a);//输出为1

        Integer b = 1000;
        test(b);
        System.out.println(b);//输出为1000
        test1(b);
        System.out.println(b);//输出为1000
    }

    public static void test(Integer s) {
        s = 123;
    }

    public static void test1(Integer s) {
        s = s + 1;
    }

}
```

Float：**即包装类作为函数的形参时，和其对应的基本类型作为形参效果一样，都是传递值，对于该对象本身并不会改变**。

```
public class FloatTest {

    public static void main(String[] args) {
        Float f = 1.2f;
        test(f);
        System.out.println(f);//输出为1.2

        float f1 = 2.4f;
        test1(f1);
        System.out.println(f1);//输出为2.4
    }

    public static void test(Float f) {
        f = f + 1;
    }

    public static void test1(float f) {
        f = f + 1;
    }
}
```

Long：

```
public class LongTest {

    public static void main(String[] args) {

        Long a = 12345L;
        test(a);
        System.out.println(a);//输出为12345

        long b = 54321L;
        test1(b);
        System.out.println(b);//输出为54321

    }

    public static void test(Long a) {
        a = a + 1;
    }

    public static void test1(long a) {
        a = a + 1;
    }
}
```

Double：

```
public class DoubleTest {
    public static void main(String[] args) {

        Double d = 12.34D;
        test(d);
        System.out.println(d);//输出为12.34

        double d1 = 34.12D;
        test(d1);
        System.out.println(d1);//输出为34.12
    }

    public static void test(Double d) {
        d = d + 1;
    }

    public static void test1(double d) {
        d = d + 1;
    }
}
```

## 总结

包装类的值都是**final** 不可变的，对于++b 或者b++ ，只是新创建了一个对象，然后把引用传给了原对象句柄，在函数中操作，只是形参的临时句柄改变了指向，实参的句柄还是指向原来的对象。所以实参的值不会改变。





