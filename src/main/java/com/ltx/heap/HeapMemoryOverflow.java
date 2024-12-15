package com.ltx.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 *
 * @author tianxing
 */
public class HeapMemoryOverflow {

    @SuppressWarnings({"InfiniteLoopStatement", "MismatchedQueryAndUpdateOfCollection"})
    public static void main(String[] args) {
        int count = 0;
        List<String> list = new ArrayList<>();
        String str = "hello";
        try {
            while (true) {
                list.add(str);
                str = str + str;
                count++;
            }
        } catch (OutOfMemoryError e) {
            // java.lang.OutOfMemoryError: Java heap space
            e.printStackTrace(System.err);
            // count = 26
            System.out.println(count);
        }
    }
}
