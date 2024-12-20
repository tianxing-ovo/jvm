package com.ltx.stack;

/**
 * 栈内存溢出
 *
 * @author tianxing
 */
public class StackMemoryOverflow {

    private static int count = 0;

    /**
     * 虚拟机选项: -Xss128k
     */
    public static void main(String[] args) {
        try {
            method();
        } catch (StackOverflowError e) {
            // count = 1094
            System.out.println(count);
        }
    }

    /**
     * 栈帧过多导致栈内存溢出
     */
    @SuppressWarnings("InfiniteRecursion")
    public static void method() {
        count++;
        method();
    }
}
