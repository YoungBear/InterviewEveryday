#Static 方法

阅读如下代码。 请问，对语句行 test.hello(). 描述正确的有（）

A. 能编译通过，并正确运行

B. 因为使用了未初始化的变量，所以不能编译通过

C. 以错误的方式访问了静态方法

D. 能编译通过，但因变量为null，不能正常运行

```
//MyApplication.java
/**
 * 原题链接：https://www.nowcoder.com/profile/3615811/myFollowings/detail/2329263
 */
public class MyApplication {

    public static void main(String[] args) {
        TestHello testHello = null;
        testHello.hello();
    }
}

//TestHello.java
public class TestHello {
    public static void hello() {
        System.out.println("hello");
    }
}
```

正确答案是A，能编译通过，并正确运行。
##解析：


因为TestHello类的hello方法是静态的，所以是属于类的，当实例化该类的时候，静态会被优先加载而且只加载一次，所以不受实例化new TestHello();影响，只要是使用到了TestHello类，都会加载静态hello方法！
另外，在其他类的静态方法中也是可以调用公开的静态方法，此题hello方法是使用public修饰的所以在MyApplication中调用hello也是可以的。

总结：即使TestHello testHello = null;这里也会加载静态方法，所以testHello数据中包含TestHello类的初始化数据。（静态的，构造的，成员属性）

因此testHello.hello()是会调用到hello方法的。

根据阿里巴巴JAVA开发手册，（四）OOP规约 第一条：

**1. 【强制】避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用<font color=red>类名</font>来访问即可。**