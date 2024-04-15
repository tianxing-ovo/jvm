package reference;

import constant.Constant;
import util.ReferenceUtil;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 弱引用应用:
 */
public class WeakReferenceApplication {

    /**
     * 参数设置: -Xmx20m -XX:+PrintGCDetails -verbose:gc
     */
    public static void main(String[] args) throws Exception {
        // List --> WeakReference --> byte[]
        List<WeakReference<byte[]>> list = new ArrayList<>();
        // 引用队列: 弱引用的对象被垃圾回收时,弱引用本身会被加入引用队列中
        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<>();
        for (int i = 0; i < 10; i++) {
            list.add(new WeakReference<>(new byte[Constant._4MB], referenceQueue));
            list.forEach(weakReference -> System.out.print(weakReference.get() + " "));
            System.out.println();
        }
        // 获取引用队列的长度
        ReferenceUtil.printQueueLength(referenceQueue);
        // 移除不再使用的弱引用
        ReferenceUtil.removeWeakReference(referenceQueue, list);
        System.out.println("================================================");
        list.forEach(weakReference -> System.out.print(weakReference.get() + " "));
    }
}
