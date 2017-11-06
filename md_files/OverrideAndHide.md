# 继承

## 覆盖与隐藏
隐藏 和覆盖 均发生在子类与父类之间，覆盖指父类实例方法被子类同名实例方法覆盖，隐藏是针对父类中的**成员变量**和**静态方法**而言 。

## 覆盖
- 子类的实例方法不能覆盖父类的静态方法；
- 子类的静态方法也不能覆盖父类的实例方法；
   即方法不能交叉覆盖。
   
## 隐藏：
父类和子类拥有相同名字的属性或者方法时，父类的同名的属性或者形式上不见了，实际上还是存在的。

### 静态方法只能隐藏，不能被覆盖。

**注意**：当发生隐藏时，**声明类型**是什么类，就调用对应类的属性或方法，而不会发生动态绑定。

- 方法隐藏只有一种形式，就是父类和子类存在相同的静态方法。
- 属性只能被隐藏，不能被覆盖。子类实例变量/静态变量可以隐藏父类中的属性。
- 强制类型转换，被隐藏的属性，在子类被强制转换成父类后，访问的是父类中的属性

题目链接：

https://www.nowcoder.com/questionTerminal/6080d0e94cee4ce5952064f96f2b1650

测试代码:

https://github.com/YoungBear/InterviewEveryday/tree/master/InterviewExperiment/src/com/interview/inherit/pratice20170614