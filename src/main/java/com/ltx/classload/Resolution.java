package com.ltx.classload;

import java.io.IOException;

/**
 * 解析的含义
 *
 * @author tianxing
 */
public class Resolution {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // 不会导致类的解析和初始化
        classLoader.loadClass("com.ltx.classload.C");
        // 会导致类的解析和初始化(空类不会解析)
        new C();
        System.in.read();
    }
}

class C {
    int i = 1;
}
