package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Test03 {

    //注解可以显示赋值,如果没有默认值,则必须给注解赋值
    @MyAnnotation2(age=27)
    public void test(){
    }

    @MyAnnotation3("清华大学")
    public void test2(){
    }
}

@Target(value={ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
    //注解的参数: 参数类型 + 参数名();
    String name() default "";
    int age();
    int id() default  -1; //如果默认值为-1,代表不存在
    String[] schools() default {"清华大学","北京大学"};
}

@Target(value={ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
    String value();
}
