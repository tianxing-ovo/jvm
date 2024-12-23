package com.ltx.jmm;

/**
 * 可见性(Visibility)
 *
 * @author tianxing
 */
public class Visibility {

    // volatile: 每次使用前立即从主内存刷新
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (running) {
                // synchronized: 清空工作内存中共享变量的值
                System.out.println("running");
            }
        }).start();
        Thread.sleep(1000);
        running = false;
    }
}
