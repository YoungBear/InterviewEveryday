# try-catch-finally 与返回值的修改

### 先看一段java代码，func返回值为int：

```
public static int func() {
    int result = 0;
    try {
        result = 1;
        return result;
    } catch (Exception e) {
        result = 2;
        return result;
    } finally {
        result = 3;
    }
}
```

正确的返回结果是，func返回1。

## 原因：

如果finally中没有return语句，但是改变了要返回的值，这里有点类似与引用传递和值传递的区别，分以下两种情况，：

1）如果return的数据是**基本数据类型**或文本**字符串**，则在finally中对该基本数据的改变不起作用，try中的return语句依然会返回进入finally块之前保留的值。

2）如果return的数据是**引用数据类型**，而在finally中对该引用数据类型的属性值的改变起作用，try中的return语句返回的就是在finally中改变后的该属性的值。

###　return 是String类型的code：

```
    public static String funcStr() {
        String result = "hello";
        try {
            result = "1";
            return result;
        } catch (Exception e) {
            result = "2";
            return result;
        } finally {
            result = "3";
        }
    }
```
该函数返回值为字符串"1"。

### 返回值是引用数据类型(对象)：

```
    public static Person funcPerson() {
        Person result = new Person(20);
        try {
            result.age = 30;
            return result;
        } catch (Exception e) {
            result.age = 40;
            return result;
        } finally {
            result.age = 50;
        }
    }
    
    static class Person {
        public int age;
        public Person(int age) {
            this.age = age;
        }
    }
```

该函数的返回类型是resultPerson,age为50，即在finally中更改了有效。

### finally中有return语句

```
    /**
     * finally中的return语句会覆盖try和catch中的return语句
     * @return
     */
    public static int getNumber() {
        int num = 0;
        try {
            int result = 2 / num;
            return result;
        } catch (Exception exception) {
            return 0;
        } finally {
            if (num == 0) {
                return -1;
            } else if (num == 1) {
                return 1;
            }
        }
    }
```

由于finally语句一定会执行，所以，如果finally中有return挥着throw语句，将覆盖try-catch中的return或者throw语句。上例返回结果为-1。

## 总结：

如果没有异常出现，而且finally语句中没有return，则会执行try里边的return，并且，会将变量**暂存**起来(对象存的是引用的地址)，再去执行finally中的语句，这时候，如果返回值是基本数据类型或者字符串，则finally相当于更改副本，不会对暂存值有影响；但是，如果返回值是对象，则finally中的语句，仍会根据地址的副本，改变原对象的值。所以上边的例子，返回值的age为50。

## 测试代码地址:

https://github.com/YoungBear/InterviewEveryday/blob/master/InterviewExperiment/src/com/interview/inherit/FinallyReturnTest.java

参考：

http://blog.csdn.net/zhumintao/article/details/53818972

http://blog.csdn.net/kavensu/article/details/8067850

