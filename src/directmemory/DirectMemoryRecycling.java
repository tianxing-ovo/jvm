package directmemory;

import constant.Constant;

import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * 直接内存回收
 */
public class DirectMemoryRecycling {

    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws IOException {
        // 使用Cleaner(虚引用)监测ByteBuffer对象,一旦ByteBuffer对象被垃圾回收,ReferenceHandler线程通过Cleaner的clean方法调用Unsafe的freeMemory方法释放直接内存
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(Constant._1GB);
        System.out.println("分配完毕");
        System.in.read();
        System.out.println("开始释放");
        byteBuffer = null;
        // 显式垃圾回收, full GC
        System.gc();
        System.in.read();
    }
}
