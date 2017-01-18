下面程序运行的结果是什么：

```
public class Example {

    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String[] args) {
        Example ex = new Example();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char[] ch) {
        str = "test ok";
        ch[0] = 'g';
    }
}
```

正确输出的结果是：`good and gbc`

解析：

这道题是形参和实参的问题。ex调用change方法的时候，将ex.str变量(实参)的**值**赋给了change方法中的str变量(形参)，而将ex.ch(实参)的**地址**赋给了change方法重的ch(形参)。change方法运行时，第一条语句改变的是方法中形参的值，对实参没有影响，第二条语句由于是直接改变的ch**所指地址**的值，所以把实参也进行了改变。