##下面代码的输出是什么？(继承，构造方法，多态)
```
public class Base {

    private String baseName = "base";

    public Base() {
        callName();
    }

    public void callName() {
        System.out.println("baseName: " + baseName);
    }

    static class Sub extends Base {
        private String baseName = "sub";

        @Override
        public void callName() {
            System.out.println("baseName: " + baseName);
        }
    }

    public static void main(String[] args) {
        Base b = new Sub();
    }
}
```

A. baseName: null

B. baseName: sub

C. baseName: base

##分析
正确答案应该是A. baseName: null

`new Sub();`在创造派生类的过程中<font color=red>首先创建基类对象</font>，然后才能创建派生类。

创建基类即默认调用Base()方法，在方法中调用callName()方法，由于派生类中覆盖了此方法(多态)，则会调用派生类中的callName()方法，此时派生类还未构造，所以变量baseName的值为默认值null。(如果int值，则为0)

##[原题链接](https://www.nowcoder.com/questionTerminal/c2bfb1512dfa4a7eab773a5871a52402 "")

