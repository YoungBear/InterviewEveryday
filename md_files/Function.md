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

再看一个例子：

```
public class Test {

    public static void main(String[] args) {
        StringBuffer a = new StringBuffer("A");
        StringBuffer b = new StringBuffer("B");
        operator(a, b);
        System.out.println(a + " , " + b);
    }

    public static void operator(StringBuffer x, StringBuffer y) {
        x.append(y);
        y = x;
    }

}
```

正确的输出结果是: AB , B

解析：

Java 程序设计语言对对象采用的不是引用调用，实际上，对象引用进行的是值传递。

Java 程序设计语言中方法参数的使用情况：

1. 一个方法不能修改一个基本数据类型的参数
2. 一个方法可以改变一个对象参数的状态
3. 一个方法不能让对象参数引用一个新的对象

此题违反了第3条。
x,y 是a,b的对象拷贝，也就是说y和b指向同一个对象，但是在方法里把y对象引用改变了，违反第3条，所以b的对象引用不会改变。

Java参数，不管是原始类型还是引用类型，传递的都是**副本**(有另外一种说法是传值，但是说传副本更好理解吧，传值通常是相对传地址而言)。如果参数类型是原始类型，那么传过来的就是这个参数肚饿一个副本，也就是这个原始参数的值，这个跟之前所谈的传值是一样的。如果在函数中改变了副本的值，原始的值是不会改变的。如果参数类型是引用类型那么传过来的就是这个引用参数的副本，这个副本存放的就是参数的**地址**。如果在函数中没有改变这个副本的地址，而是改变了地址中的值，那么在函数内的改变会**影响到传入的参数**。如果在函数中改变了副本的地址，如new一个，那么副本就指向了一个新的地址，此时传入的参数还是指向原来的地址，所以不会改变参数的值。

具体结合例子，在Example中，由于String是基本不变类，是无法修改值的，所以哪怕在进行参数传递的时候， **如果尝试修改其值，那么虚拟机会重新分配一个新的内存给String**，所以ex调用change函数之后，其ex.str并没有改变。但是，StringBuffer是可变类，在Test中，a,x都指向同一个对象，这时候通过x来修改该对象，则该对象的值就会发生改变，所以a的值变成了AB。但是，刚开始的时候，b,y指向同一个对象，执行了`y = x`这句话之后，y指向了x的对象(不再指向b的对象)，所以，这对b的对象没有任何影响，所以b的值还是B。
