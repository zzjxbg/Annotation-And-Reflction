package com.reflection;

//测试Class类的创建方式有哪些
public class Test03 {
    public static void main(String[] args) throws ClassNotFoundException {

        Person person = new Student();
        System.out.println("这个人是:" + person.name);

        //方式一:通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1);

        //方式二:forname获得
        Class c2 = Class.forName("com.reflection.Student");
        System.out.println(c2);

        //方式三:类名直接获得
        Class c3 = Student.class;
        System.out.println(c3);

        //方式四:基本内置类型的包装类都有一个TYPE属性
        Class c4 = Integer.TYPE;
        System.out.println(c4);

        //获得父类类型
        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }

}

class Person {

    String name;

    public Person(){}

    public Person(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

}

class Student extends Person{
    public Student() {
        this.name="学生";
    }
}

class Teacher extends  Person{
    public Teacher() {
        this.name="老师";
    }
}