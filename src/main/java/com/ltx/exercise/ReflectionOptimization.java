package com.ltx.exercise;

import java.lang.reflect.Method;

/**
 * 反射优化
 *
 * @author tianxing
 */
@SuppressWarnings("ResultOfMethodCallIgnored")
public class ReflectionOptimization {
    public static void main(String[] args) throws Exception {
        Method method = ReflectionOptimization.class.getDeclaredMethod("foo");
        // 1-15次使用NativeMethodAccessorImpl的invoke0本地方法来执行方法调用
        // 16次使用MethodAccessorGenerator生成一个方法访问器(仍然使用invoke0)
        // 17次开始使用新生成的方法访问器来执行方法调用
        for (int i = 1; i <= 17; i++) {
            System.out.printf("%d\t", i);
            method.invoke(null);
        }
        // 使用arthas反编译sun.reflect.GeneratedMethodAccessor1
        System.in.read();
    }

    public static void foo() {
        System.out.println("foo");
    }
}
