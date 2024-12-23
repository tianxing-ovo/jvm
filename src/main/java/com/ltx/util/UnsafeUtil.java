package com.ltx.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe工具类
 *
 * @author tianxing
 */
public class UnsafeUtil {

    private static final Unsafe UNSAFE = getUnsafe();

    /**
     * 反射获取Unsafe对象
     */
    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            // null表示获取静态变量
            return ((Unsafe) field.get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 分配内存
     *
     * @param size 内存大小
     * @return 内存地址
     */
    public static long allocateMemory(long size) {
        return UNSAFE.allocateMemory(size);
    }

    /**
     * 填充内存为一个值
     *
     * @param address 内存地址
     * @param size    内存大小
     * @param value   填充值
     */
    public static void setMemory(long address, long size, byte value) {
        UNSAFE.setMemory(address, size, value);
    }

    /**
     * 释放内存
     *
     * @param address 内存地址
     */
    public static void freeMemory(long address) {
        UNSAFE.freeMemory(address);
    }
}
