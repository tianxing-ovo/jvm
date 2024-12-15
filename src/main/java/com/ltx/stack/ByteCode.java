package com.ltx.stack;

/**
 * 演示字节码指令和操作数栈/常量池的关系
 *
 * @author tianxing
 */
public class ByteCode {
    public static void main(String[] args) {
        // bipush 10 -> istore_1
        int a = 10;
        // ldc 32768(超过short最大值就存储在常量池中) -> istore_2
        // 常量折叠: 编译期间计算好表达式结果
        int b = Short.MAX_VALUE + 1;
        // iload_1 -> iload_2 -> iadd -> istore_3
        int c = a + b;
        // getstatic(获取PrintStream对象引用) -> iload_3 -> invokevirtual
        System.out.println(c);
    }
}
