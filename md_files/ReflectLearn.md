# Java 反射机制

## 反射机制的用处：(from JAVA核心技术)

- 在运行中分析类的能力。
- 在运行中查看对象，例如，编写一个toString方法供所有类使用。
- 实现通用的数组操作代码。
- 利用Method对象，这个对象很像C++中的函数指针。

反射是一种功能强大且复杂的机制。使用它的主要人员是工具构造者，而不是应用程序员。

## 常用API
类：
```
java.lang.Class;                
java.lang.reflect.Constructor;
java.lang.reflect.Field;        
java.lang.reflect.Method;
java.lang.reflect.Modifier;
```

注意：一下函数的返回数组，均不确定顺序。
参考：getMethods()的javaDoc。
`The elements in the returned array are not sorted and are not in any particular order.`

https://www.zhihu.com/question/28587328/answer/41441976
```
getDeclaredFields()与getFields()
//getDeclaredFields()返回Class中所有的字段，包括私有字段；
//getFields()返回公有字段，即public字段。
getDeclaredMethods()与getMethods()
//getDeclaredMethods()返回该Class的public,protected,defalut,private以及实现接口的方法，但不包括继承的方法；
//getMethods()除了上述方法之外，还包括继承的方法。
getDeclaredConstructors()与getConstructors()
//getDeclaredConstructors()返回所有(包括public,protected,default,private)构造方法
//getConstructors()返回public的构造方法
```

## 获取Class的三种方法

1. `Class.forName()`
2. `ClassName.class`
3. `getClass()`
```
//Class.forName()
Class c1 = Class.forName("com.interview.reflect.Employee");
//ClassName.class
Class c2 = Employee.class;
//getClass()
Employee e = new Employee(30, "John", 10000f);
Class c3 = e.getClass();
```

## getName(),getSimpleName()与getCanonicalName()
对于大部分class而言，getCanonicalName和getName这两个方法没有什么不同的， 但是对于**数组**类型就显示出来了。

getName()方法，以String的形式，返回Class对象的‘实体’名称；

getSimpleName()方法，是获取源代码中给出的‘底层类’简称；

参考：

http://www.cnblogs.com/birkhoff/p/5274562.html

http://www.cnblogs.com/rollenholt/archive/2011/09/02/2163758.html

## 创建对象
### getDeclaredConstructors()与getConstructors()
- getDeclaredConstructors()返回所有(包括public,protected,default,private)构造方法
- getConstructors()返回public的构造方法
- 两个函数均不会返回父类的构造函数

### 第一种方法：
Class.newInstance()：
```
public class InstanceTest {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person person = null;
        try {
            person = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        person.setAge(20);
        person.setName("James");
        System.out.println(person);
    }
}
```
对应Person的代码为：

```
public class Person {

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
```

如果Person类没有**无参的构造方法**，就会报如下的异常：

```
java.lang.InstantiationException: com.interview.reflect.Person
	at java.lang.Class.newInstance(Class.java:427)
	at com.interview.reflect.InstanceTest.main(InstanceTest.java:17)
Caused by: java.lang.NoSuchMethodException: com.interview.reflect.Person.<init>()
	at java.lang.Class.getConstructor0(Class.java:3082)
	at java.lang.Class.newInstance(Class.java:412)
	... 1 more
Exception in thread "main" java.lang.NullPointerException
	at com.interview.reflect.InstanceTest.main(InstanceTest.java:23)
```

所以，使用`Class.newInstance()`来创建新对象的时候，必须有一个无参的构造函数。

### 第二种方法：

Constructor.newInstance();

Person类：
```
public class Person {

    protected int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

```

测试类：
```
public class InstanceTest2 {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?> []constructors = demo.getConstructors();

        //注意，返回的数组顺序不确定，所以不要使用下标来访问
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(i + " : " + constructors[i].toGenericString());
        }
        Person person1 = null;
        Person person2 = null;
        Person person3 = null;
        Person person4 = null;

        try {
            Constructor<?> constructor1 = demo.getConstructor();
            System.out.println("constructor1: " + constructor1);
            person1 = (Person) constructor1.newInstance();

            Constructor<?> constructor2 = demo.getConstructor(int.class);
            System.out.println("constructor2: " + constructor2);
            person2 = (Person) constructor2.newInstance(20);

            Constructor<?> constructor3 = demo.getConstructor(String.class);
            System.out.println("constructor3: " + constructor3);
            person3 = (Person) constructor3.newInstance("James");

            Constructor<?> constructor4 = demo.getConstructor(int.class, String.class);
            System.out.println("constructor4: " + constructor4);
            person4 = (Person) constructor4.newInstance(20, "James");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person3);
        System.out.println(person4);

    }
}
```

**要注意的问题：**

由于Class.getConstructors()返回的数组顺序不确定，所以不能直接使用下标来newInstance()，而应该使用Class.getConstructor(Class<?>... parameterTypes)来获取对应的构造函数，进而去创建对象。

## 获取实现的接口(是一个接口数组)
`public Class<?>[] getInterfaces()`

```
public class InterfaceLearn {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> []interfaces = demo.getInterfaces();
//        String simpleName = interfaces[0].getSimpleName();
//        System.out.println("simpleName: " + simpleName);
        System.out.println("interfaces.length: " + interfaces.length);
    }
}
```

## 获取父类

`public Class<? super T> getSuperclass()`

```
public class SuperLearn {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Employee");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Class<?> superClass = demo.getSuperclass();
        System.out.println("superClass.getSimpleName(): " + superClass.getSimpleName());
    }

}
```

## 获取属性
### getDeclaredFields()与getFields()
- getDeclaredFields()返回Class中所有的字段，包括私有字段；
- getFields()返回公有字段，即public字段。

### getDeclaredField(String name)与 getField(String name)
- getDeclaredField(String name)获取指定的属性，包括private属性。
- getField(String name)获取指定的public属性，如果该属性不是public类型，则跑出java.lang.NoSuchFieldException异常。

Demo:
```
public class FieldLearn {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person person = null;

        Constructor<?> constructor = null;
        try {
            constructor = demo.getConstructor(int.class, String.class);
            person = (Person) constructor.newInstance(20, "James");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("before: " + person);

        //获取所有属性，这里只显示用
        Field[] fields = demo.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(i + " : " + fields[i].getName());
        }

        try {
            ////可以通过这种方式修改private属性的的值
            Field fieldAge = demo.getDeclaredField("age");
            fieldAge.setAccessible(true);
            fieldAge.set(person, 33);
            System.out.println(fieldAge.get(person));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        
        System.out.println("after: " + person);
    }
}
```

## 反射使用方法
### getDeclaredMethods()与getMethods()
- getDeclaredMethods()返回该Class的public,protected,defalut,private以及实现接口的方法，但不包括继承的方法；
- getMethods()除了上述方法之外，还包括继承的方法。

### getDeclaredMethod(String name, Class<?>... parameterTypes)与getMethod(String name, Class<?>... parameterTypes)
- 获取指定的方法
```
public class MethodLearn {

    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.interview.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Person person = null;

        Constructor<?> constructor = null;
        try {
            constructor = demo.getConstructor(int.class, String.class);
            person = (Person) constructor.newInstance(20, "James");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println("before: " + person);

        try {
            Method methodGetAge = demo.getMethod("getAge");
            int age = (int) methodGetAge.invoke(person);
            System.out.println("age: " + age);

            Method methodSetAge = demo.getMethod("setAge", int.class);
            methodSetAge.invoke(person, 30);
            int ageAfter = (int) methodGetAge.invoke(person);
            System.out.println("ageAfter: " + ageAfter);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
```

## 通过反射取得并修改数组的信息

```
public class ArrayLearn {

    public static void main(String[] args) {
        int[] temp = {1, 2, 3, 4, 5};
        Class<?> demo = temp.getClass().getComponentType();
        System.out.println("数组类型： " + demo.getName());
        System.out.println("数组长度  " + Array.getLength(temp));
        System.out.println("数组的第一个元素: " + Array.get(temp, 0));
        Array.set(temp, 0, 100);
        System.out.println("修改之后数组第一个元素为： " + Array.get(temp, 0));
    }
}
```

