package com.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value值
        Table table = (Table)c1.getAnnotation(Table.class);
        String value = table.value();
        System.out.println(value);

        //获得类指定的注解(先获得该属性,再获得该属性注解)
        Field f = c1.getDeclaredField("id");
        FieldAnnotation fieldAnnotation = f.getAnnotation(FieldAnnotation.class);
        System.out.println(fieldAnnotation.columnName());
        System.out.println(fieldAnnotation.type());
        System.out.println(fieldAnnotation.length());
    }
}

@Table("db_student")
class Student2 {

    @FieldAnnotation(columnName = "db_id",type="int",length=10)
    private int id;
    @FieldAnnotation(columnName = "db_age",type="int",length=10)
    private int age;
    @FieldAnnotation(columnName = "db_name",type="varchar",length=3)
    private String name;

    public Student2(){}

    public Student2(int id, int age, String name) {
        this.id=id;
        this.age=age;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldAnnotation {
    String columnName();
    String type();
    int length();
}
