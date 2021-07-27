package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象,通过反射
public class Test09 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {

        //获得Class对象
        Class c1 = Class.forName("com.reflection.User");

        //构造一个对象
        User user = (User)c1.newInstance();  //本质上调用了类的无参构造器
        System.out.println(user);

        //通过构造器创建对象
        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User user2 = (User)constructor.newInstance("哈哈",001,18);
        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);
        //invoke:激活的意思
        //(对象,"方法的值")
        setName.invoke(user3, "呵呵");
        System.out.println(user3.getName());

        //通过反射操作属性
        System.out.println("====================");
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");
        //不能直接操作私有属性,需关闭java语言安全访问检测,属性或者方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user4,"嘿嘿");
        System.out.println(user4.getName());

    }
}
