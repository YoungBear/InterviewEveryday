#Integer的自动装箱拆箱

先看一道题：

```
public static void main(String[] args) {
        Integer integer1 = 2;
        Integer integer2 = 2;

        System.out.println("integer1 == integer2: " + (integer1 == integer2));

        Integer integer3 = 200;
        Integer integer4 = 200;

        System.out.println("integer3 == integer4: " + (integer3 == integer4));
}
```

不卖关子了，输出结果为：

```
integer1 == integer2: true
integer3 == integer4: false
```
说明：

equals()比较的是两个对象的值(内容)是否相同。

“==” 比较的是两个对象的引用(内存地址)是否相同，也用来比较两个基本数据类型的变量值是否相等。

这儿涉及到java的自动装箱(autoboxing)和自动拆箱(unboxing)，那么什么是自动装箱拆箱呢？

##什么是自动装箱拆箱
基本数据类型的自动装箱、拆箱是自J2SE 5.0开始提供的功能。

一般我们要创建一个类的对象实例的时候，我们会这样：

`Class a = new Class(parameter);`

当我们创建了一个Integer对象时，却可以这样:

`Integer i = 100;(注意：不是 int i = 100;)`

实际上，执行上面那句代码的时候，系统为我们执行了

`Integer i = Integer.valueOf(100);`

此即基本数据类型的<font color=red>自动装箱</font>功能。

与此对应，还有自动拆箱(unboxing)，即将对象中的基本数据从对象中自动取出。如下可实现自动拆箱：

```
Integer i = 10;//装箱
int t = i;//拆箱，实际上执行了 int t = i.intValue();
```

##Integer的自动装箱

由于Integer的自动装箱会调用`Integer valueOf(int i)`函数，那么就看一下它的源代码：

```
    //default IntegerCache.low = -128,IntegerCache.high = 127
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
```

所以可以看出来，在-128~127(default，用户可以设置)之间的数，`Integer.valueOf(int i)` 返回的是缓存的Integer对象（并不是新建对象）。所以上面代码中的integer1和integer2指向同一个对象。而对于其它的数，执行`Integer.valueOf(int i)` 返回的是一个新建的 Integer对象，所以代码中，integer3和integer4指向的是不同的对象。

当然，当不使用自动装箱功能的时候，情况与普通类对象一样，请看下例：

```
Integer i3 =new Integer(100); 
Integer i4 =new Integer(100); 
System.out.println("i3 == i4: "+(i3 == i4));//显示false
```

##Integer自动装箱拆箱总结

自动装箱调用：`Integer.valueOf(int n);`

自动拆箱调用：`Integer.intValue();`





