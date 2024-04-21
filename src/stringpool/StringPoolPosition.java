package stringpool;

import java.util.ArrayList;
import java.util.List;

/**
 * StringPool位置
 */
public class StringPoolPosition {

    /**
     * jdk6: 位于永久代  参数设置: -XX:MaxPermSize=10m
     * jdk8: 位于堆  参数设置: -Xmx5m -XX:-UseGCOverheadLimit
     */
    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int count = 0;
        try {
            for (int i = 0; i < 100000; i++) {
                list.add(String.valueOf(i).intern());
                count++;
            }
        } catch (OutOfMemoryError e) {
            // java.lang.OutOfMemoryError: Java heap space
            e.printStackTrace(System.err);
            // count = 75399
            System.out.println(count);
        }
    }
}
