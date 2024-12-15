package com.ltx.exercise;

/**
 * 方法内联: 把目标方法的代码原封不动地"复制"到发起调用的方法之中 -> 避免发生真实的方法调用
 *
 * @author tianxing
 */
public class Inlining {

    /**
     * 虚拟机选项: -XX:+UnlockDiagnosticVMOptions -XX:+PrintInlining -XX:CompileCommand=dontinline,*Inlining.sum
     */
    public static void main(String[] args) {
        int result = 0;
        for (int i = 1; i <= 1000; i++) {
            long start = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                // 方法内联: result = 1 + 2
                // 常量折叠(Constant Folding): result = 3
                result = sum(1, 2);
            }
            long end = System.nanoTime();
            System.out.printf("第%d次循环 结果:%d 花费了%dns\n", i, result, (end - start));
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }
}
