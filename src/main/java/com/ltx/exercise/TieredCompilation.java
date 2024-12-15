package com.ltx.exercise;

import java.io.IOException;

/**
 * 分层编译: "热点代码"(Hot Spot Code)进行即时编译
 * "热点代码"(Hot Spot Code): 1.被多次调用的方法 2.被多次执行的循环体
 *
 * @author tianxing
 */
public class TieredCompilation {

    /**
     * 虚拟机选项: -XX:+DoEscapeAnalysis -XX:+EliminateAllocations
     */
    public static void main(String[] args) throws IOException {
        for (int i = 1; i <= 1000; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                // 对象不会被方法外部访问 -> 不会创建对象
                new Object();
            }
            long end = System.nanoTime();
            System.out.println("第" + i + "次循环，花费了" + (end - start) + "ns");
        }
    }
}
