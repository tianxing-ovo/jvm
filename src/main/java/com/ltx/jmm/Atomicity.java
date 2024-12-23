package com.ltx.jmm;

/**
 * 原子性(Atomicity)
 *
 * @author tianxing
 */
public class Atomicity {
    private static int a = 0;
    private static int b = 0;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("threadUnSafe: a = " + threadUnSafe());
        System.out.println("threadSafe: b = " + threadSafe());
    }

    /**
     * 线程不安全
     * 原因: a++和a--不是原子操作 -> 对应4条字节码指令 -> 多线程下指令可能会交错执行
     *
     * @return int
     * @throws InterruptedException 中断异常
     */
    public static int threadUnSafe() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // getstatic -> iconst_1 -> iadd -> putstatic
                a++;
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                // getstatic -> iconst_1 -> isub -> putstatic
                a--;
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return a;
    }

    /**
     * 线程安全
     *
     * @return int
     * @throws InterruptedException 中断异常
     */
    public static int threadSafe() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            synchronized (Atomicity.class) {
                for (int i = 0; i < 5000; i++) {
                    // getstatic -> iconst_1 -> iadd -> putstatic
                    b++;
                }
            }
        }, "t1");
        Thread t2 = new Thread(() -> {
            synchronized (Atomicity.class) {
                for (int i = 0; i < 5000; i++) {
                    // getstatic -> iconst_1 -> isub -> putstatic
                    b--;
                }
            }
        }, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        return b;
    }
}
