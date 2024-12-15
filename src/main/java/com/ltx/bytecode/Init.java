package com.ltx.bytecode;

/**
 * <init>: 实例构造器
 * 执行顺序: 字段初始化/实例初始化块(按照在类中定义的顺序执行) -> 构造方法
 *
 * @author tianxing
 */
public class Init {

    // ldc "s1" -> putfield
    private String a = "s1";

    // bipush 10 -> putfield
    private int b = 10;

    {
        // 可以先赋值再声明但不能使用
        // bipush 20 -> putfield
        b = 20;
    }

    {
        // ldc "s2" -> putfield
        a = "s2";
    }

    public Init(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Init init = new Init("s3", 30);
        // a="s3"
        System.out.println("a=" + init.a);
        // b=30
        System.out.println("b=" + init.b);
    }
}
