package directmemory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Unsafe工具类
 */
public class UnsafeUtil {

    private static final Unsafe unsafe = getUnsafe();

    /**
     * 反射获取Unsafe对象
     */
    private static Unsafe getUnsafe() {
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
        return unsafe.allocateMemory(size);
    }

    /**
     * 填充内存为一个值
     *
     * @param address 内存地址
     * @param size    内存大小
     * @param value   填充值
     */
    public static void setMemory(long address, long size, byte value) {
        unsafe.setMemory(address, size, value);
    }

    /**
     * 释放内存
     *
     * @param address 内存地址
     */
    public static void freeMemory(long address) {
        unsafe.freeMemory(address);
    }
}
