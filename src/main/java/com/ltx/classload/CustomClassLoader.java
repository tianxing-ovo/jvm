package com.ltx.classload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 自定义类加载器
 *
 * @author tianxing
 */
public class CustomClassLoader extends ClassLoader {
    public static void main(String[] args) throws Exception {
        CustomClassLoader loader1 = new CustomClassLoader();
        Class<?> c1 = loader1.loadClass("Test");
        Class<?> c2 = loader1.loadClass("Test");
        // true(同一个类加载器实例加载相同的类会返回同一个Class对象)
        System.out.println(c1 == c2);
        CustomClassLoader loader2 = new CustomClassLoader();
        Class<?> c3 = loader2.loadClass("Test");
        // false(不同的类加载器实例加载相同的类会返回不同的Class对象)
        System.out.println(c1 == c3);
        // 创建对象触发类的初始化
        c1.newInstance();
    }

    /**
     * 查找并加载类
     *
     * @param name 类的全限定名
     * @return Class对象
     */
    @Override
    protected Class<?> findClass(String name) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(System.getProperty("user.home"), "Desktop", name + ".class"));
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
