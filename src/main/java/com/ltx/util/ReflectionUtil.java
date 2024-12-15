package com.ltx.util;


import com.ltx.constant.Constant;

import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Field;

/**
 * 反射工具类
 *
 * @author tianxing
 */
public class ReflectionUtil {

    /**
     * 获取引用队列长度
     *
     * @param referenceQueue 引用队列
     * @return 队列长度
     */
    public static Object getQueueLength(ReferenceQueue<byte[]> referenceQueue) throws Exception {
        Field field = ReferenceQueue.class.getDeclaredField(Constant.QUEUE_LENGTH);
        field.setAccessible(true);
        return field.get(referenceQueue);
    }
}
