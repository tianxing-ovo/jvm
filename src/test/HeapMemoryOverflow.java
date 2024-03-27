package test;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出
 */
public class HeapMemoryOverflow {
    @SuppressWarnings({"InfiniteLoopStatement", "MismatchedQueryAndUpdateOfCollection"})
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        String str = "hello";
        try {
            while (true) {
                list.add(str);
                str = str + str;
                i++;
            }
        } catch (OutOfMemoryError e) {
            System.out.println(i);
        }
    }
}
