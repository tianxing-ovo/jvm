package reference;


import constant.Constant;
import util.ReferenceUtil;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用应用: 防止内存溢出
 */
public class SoftReferenceApplication {

    /**
     * 参数设置: -Xmx20m -XX:+PrintGCDetails -verbose:gc
     */
    public static void main(String[] args) throws Exception {
        // List --> SoftReference --> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        // 引用队列: 软引用的对象被垃圾回收时,软引用本身会被加入引用队列中
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        for (int i = 0; i < 5; i++) {
            SoftReference<byte[]> softReference = new SoftReference<>(new byte[Constant._4MB], referenceQueue);
            System.out.println(softReference.get());
            list.add(softReference);
        }
        // 打印引用队列的长度
        ReferenceUtil.printQueueLength(referenceQueue);
        // 移除不再使用的软引用
        ReferenceUtil.removeSoftReference(referenceQueue, list);
        System.out.println("================================================");
        list.forEach(softReference -> System.out.println(softReference.get()));
    }
}
