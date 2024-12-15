package com.ltx.exercise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 使用反射获取泛型信息
 *
 * @author tianxing
 */
public class Genericity<T> {

    private final List<T> list = new ArrayList<>();

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        // 获取方法参数的泛型信息
        Method method = Genericity.class.getMethod("test", List.class, Map.class);
        for (Type type : method.getGenericParameterTypes()) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                System.out.println("方法参数原始类型: " + parameterizedType.getRawType());
                System.out.println("方法参数泛型参数: " + Arrays.toString(parameterizedType.getActualTypeArguments()));
            }
        }
        // 获取方法返回值的泛型信息
        Type returnType = method.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) returnType;
            System.out.println("方法返回值原始类型: " + parameterizedType.getRawType());
            System.out.println("方法返回值泛型参数: " + Arrays.toString(parameterizedType.getActualTypeArguments()));
        }
        // 获取成员变量的泛型信息
        Field field = Genericity.class.getDeclaredField("list");
        field.setAccessible(true);
        Type fieldType = field.getGenericType();
        if (fieldType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) fieldType;
            System.out.println("字段原始类型: " + parameterizedType.getRawType());
            System.out.println("字段泛型参数: " + Arrays.toString(parameterizedType.getActualTypeArguments()));
        }

    }

    public List<String> test(List<Integer> list, Map<Integer, Object> map) {
        return new ArrayList<>();
    }
}
