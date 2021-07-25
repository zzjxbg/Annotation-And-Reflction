package com.annotation;

import java.lang.annotation.*;

//元注解
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test() {

    }
}

//定义一个注解

//Target 表示注解可以用在哪些地方
@Target(value= {ElementType.METHOD,ElementType.TYPE})

//Retention 表示注解在什么地方还有效
//Runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 表示是否将注解生成在JAVA doc中
@Documented

//Inherited 子类可以继承父类的注解
@Inherited
@interface MyAnnotation {

}
