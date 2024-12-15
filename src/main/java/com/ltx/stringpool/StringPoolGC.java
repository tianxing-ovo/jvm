package com.ltx.stringpool;

/**
 * StringPool垃圾回收
 *
 * @author tianxing
 */
public class StringPoolGC {

    /**
     * 参数设置: -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc -XX:StringTableSize=100000
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            String.valueOf(i).intern();
        }
    }
}
