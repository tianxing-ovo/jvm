package com.ltx.classload;

import java.util.Arrays;

/**
 * 初始化
 *
 * @author tianxing
 */
public class Initialization {

    static {
        System.out.println("main init");
    }

    /**
     * 虚拟机选项: -XX:+TraceClassLoading
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // 访问基本类型final静态变量不会触发初始化
        System.out.println(SubClass.MAX_VALUE);
        // 访问String类型final静态变量不会触发初始化
        System.out.println(SubClass.APP_NAME);
        // 访问类的class对象不会触发初始化
        System.out.println(SubClass.class);
        // 通过数组定义来引用类不会触发初始化
        System.out.println(Arrays.toString(new SubClass[0]));
        // 获取线程上下文类加载器(默认是AppClassLoader)
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        // initialize=false时不会触发初始化
        Class.forName("classload.SubClass", false, classLoader);
        // 访问非final静态变量会触发初始化
        System.out.println(SuperClass.value);
        // 子类访问父类的静态变量只会触发父类初始化
        System.out.println(SubClass.value);
        // 当初始化类的时候,如果发现其父类还没有进行过初始化,则需要先触发其父类的初始化
        System.out.println(SubClass.num);
    }
}

class SuperClass {
    public static int value = 123;

    static {
        System.out.println("SuperClass init");
    }
}

class SubClass extends SuperClass {
    public static final int MAX_VALUE = 100;
    public static final String APP_NAME = "MyApp";
    public static int num = 456;

    static {
        System.out.println("SubClass init");
    }
}
