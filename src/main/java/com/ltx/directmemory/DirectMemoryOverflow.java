package com.ltx.directmemory;


import com.ltx.constant.Constant;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * 直接内存溢出
 *
 * @author tianxing
 */
public class DirectMemoryOverflow {

    @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "InfiniteLoopStatement"})
    public static void main(String[] args) {
        List<ByteBuffer> list = new ArrayList<>();
        int count = 0;
        try {
            while (true) {
                list.add(ByteBuffer.allocateDirect(Constant._100MB));
                count++;
            }
        } catch (OutOfMemoryError e) {
            // java.lang.OutOfMemoryError: Direct buffer memory
            e.printStackTrace(System.err);
            // count = 35
            System.out.println(count);
        }
    }
}

