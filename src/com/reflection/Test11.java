package com.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class Test11 {

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Test11.class.getMethod("test01",Map.class,List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();  //通过反射方法获得参数化的泛型
        for(Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            if(genericParameterType instanceof ParameterizedType) {
                Type[] actualTypeArguments = ((ParameterizedType)genericParameterType).getActualTypeArguments();
                for(Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }

        method = Test11.class.getMethod("test02",null);
        Type genericReturnType = method.getGenericReturnType();  //获得返回值泛型
        if(genericReturnType instanceof ParameterizedType) {
            Type[] actualTypeArguments = ((ParameterizedType)genericReturnType).getActualTypeArguments();
            for(Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }
    }
}
