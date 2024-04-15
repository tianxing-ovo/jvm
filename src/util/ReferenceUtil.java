package util;

import constant.Constant;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.List;

/**
 * 引用工具类
 */
public class ReferenceUtil {

    /**
     * 移除不再使用的软引用
     *
     * @param referenceQueue 引用队列
     * @param list           存放软引用的列表
     */
    public static void removeSoftReference(ReferenceQueue<byte[]> referenceQueue, List<SoftReference<byte[]>> list) {
        while (true) {
            Reference<? extends byte[]> reference = referenceQueue.poll();
            if (reference == null) {
                break;
            }
            list.remove(reference);
        }
    }

    /**
     * 移除不再使用的弱引用
     *
     * @param referenceQueue 引用队列
     * @param list           存放弱引用的列表
     */
    public static void removeWeakReference(ReferenceQueue<byte[]> referenceQueue, List<WeakReference<byte[]>> list) {
        while (true) {
            Reference<? extends byte[]> reference = referenceQueue.poll();
            if (reference == null) {
                break;
            }
            list.remove(reference);
        }
    }

    /**
     * 打印引用队列的长度
     */
    public static void printQueueLength(ReferenceQueue<byte[]> referenceQueue) throws Exception {
        System.out.println(Constant.QUEUE_LENGTH + ": " + ReflectionUtil.getQueueLength(referenceQueue));
    }
}
