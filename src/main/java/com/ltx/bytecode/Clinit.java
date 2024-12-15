package com.ltx.bytecode;

/**
 * <clinit>: 类构造器
 * bipush 10/20/30: 将10/20/30加载到操作数栈中
 * putstatic i:I: 将操作数栈顶的值赋给静态字段i
 *
 * @author tianxing
 */
public class Clinit {

    // bipush 10 -> putstatic i:I
    static int i = 10;

    // bipush 20 -> putstatic i:I
    static {
        i = 20;
    }

    // bipush 30 -> putstatic i:I
    static {
        i = 30;
    }
}
