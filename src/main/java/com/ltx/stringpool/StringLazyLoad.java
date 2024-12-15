package com.ltx.stringpool;

/**
 * 字符串延迟加载
 *
 * @author tianxing
 */
public class StringLazyLoad {
    public static void main(String[] args) {
        System.out.println();
        // 字符串数量: 2195
        System.out.print("1");
        System.out.print("2");
        // 字符串数量: 2197
        System.out.print("1");
        System.out.print("2");
        // 字符串数量: 2197
        System.out.println();
    }
}
