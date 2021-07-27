package com.reflection;

public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器(应用程序的主函数类)
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器(jre/lib/ext扩展的jar)
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(c/c++)加载核心的类库(java.lang.*等)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //测试当前类是哪个加载器加载的(系统类加载器)
        ClassLoader classLoader = Class.forName("com.reflection.Test07").getClassLoader();
        System.out.println(classLoader);
        //测试JDK内置的类是谁加载的(根加载器)
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));

        //双亲委派机制
        //1、防止重复加载同一个.class。通过委托去向上面问一问，加载过了，就不用再加载一遍。保证数据安全。
        //2、保证核心.class不能被篡改。通过委托方式，不会去篡改核心.clas，即使篡改也不会去加载，
        //   即使加载也不会是同一个.class对象了。不同的加载器加载同一个.class也不是同一个Class对象这样保证了Class执行安全。


        /**
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\charsets.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\deploy.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\access-bridge-64.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\cldrdata.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\dnsns.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\jaccess.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\jfxrt.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\localedata.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\nashorn.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunec.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunjce_provider.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunmscapi.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\sunpkcs11.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\ext\zipfs.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\javaws.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\jce.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\jfr.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\jfxswt.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\jsse.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\management-agent.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\plugin.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\resources.jar;
         *  C:\Program Files\Java\jdk1.8.0_172\jre\lib\rt.jar;
         *  D:\Annotation&Reflection\out\production\Annotation&Reflection;
         *  D:\IntelliJ IDEA 2021.1.3\lib\idea_rt.jar
         */

    }
}
