package com.ltx.bytecode;

/**
 * 局部变量自增指令
 *
 * @author tianxing
 */
public class AutoIncrement {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * iload_1: 将变量a加载到操作数栈中
     * iinc 1,1: 将变量a自增1
     * iinc 1,-1: 将变量a自减1
     */
    public static void test1() {
        int a = 10;
        // a++: iload_1 -> iinc 1,1
        // ++a: iinc 1,1 -> iload_1 -> iadd
        // a--: iload_1 -> iinc 1,-1 -> iadd
        int b = a++ + ++a + a--;
        // 10 + 1 + 1 -1 = 11
        System.out.println(a);
        // 10 + 12 + 12 = 34
        System.out.println(b);
    }

    /**
     * iload_2: 将变量x加载到操作数栈中
     * iinc 2,1: 将变量x自增1
     * istore_2: 将操作数栈中的值存储到变量x中
     */
    public static void test2() {
        int i = 0;
        int x = 0;
        while (i < 10) {
            // iload_2 -> iinc 2,1 -> istore_2
            x = x++;
            i++;
        }
        // x=0
        System.out.println("x=" + x);
    }
}
