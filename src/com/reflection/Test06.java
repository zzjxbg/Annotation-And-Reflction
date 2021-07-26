package com.reflection;

//类什么时候发生初始化
public class Test06 {

    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用
        Son son = new Son();

        //2.反射也会产生主动引用
        Class.forName("com.reflection.Son");

        //不会产生类的引用的方法(被动引用)
        System.out.println(Son.b);  //子类调用父类的静态变量

        Son[] array = new Son[5];  //通过数组定义类引用

        System.out.println(Son.M);  //引用常量(常量在链接阶段就存入调用类的常量池中)
    }
}

class Father {
    static int b = 2;
    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}
