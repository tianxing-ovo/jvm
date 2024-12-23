package com.ltx.jmm;

import com.ltx.util.UnsafeUtil;
import lombok.AllArgsConstructor;
import sun.misc.Unsafe;

/**
 * CAS(Compare And Swap): 比较并交换
 *
 * @author tianxing
 */
@AllArgsConstructor
public class CAS {
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();
    private static final long VALUE_OFFSET;

    static {
        try {
            // 获取CAS类中value字段的偏移量(内存地址)
            VALUE_OFFSET = UNSAFE.objectFieldOffset(CAS.class.getDeclaredField("value"));
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private volatile int value;

    public static void main(String[] args) throws InterruptedException {
        CAS cas = new CAS(0);
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                cas.increment();
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                cas.decrement();
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cas.value);
    }

    /**
     * 自增
     */
    public void increment() {
        // 旧的预期值
        int expect;
        // 准备设置的新值
        int update;
        while (true) {
            expect = UNSAFE.getIntVolatile(this, VALUE_OFFSET);
            update = expect + 1;
            // CAS操作: 如果当前值等于旧的预期值则更新为新值
            if (UNSAFE.compareAndSwapInt(this, VALUE_OFFSET, expect, update)) {
                return;
            }
        }
    }

    /**
     * 自减
     */
    public void decrement() {
        // 旧的预期值
        int expect;
        // 准备设置的新值
        int update;
        while (true) {
            expect = UNSAFE.getIntVolatile(this, VALUE_OFFSET);
            update = expect - 1;
            // CAS操作: 如果当前值等于旧的预期值则更新为新值
            if (UNSAFE.compareAndSwapInt(this, VALUE_OFFSET, expect, update)) {
                return;
            }
        }
    }
}
