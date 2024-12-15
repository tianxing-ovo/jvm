package com.ltx.util;

/**
 * 堆栈跟踪工具
 *
 * @author tianxing
 */
public class StackTraceUtil {
    public static void printStackTrace() {
        Thread.getAllStackTraces().forEach((thread, stackTraceElements) -> {
            System.out.println("线程: " + thread.getName());
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                System.out.println("\t" + stackTraceElement);
            }
        });
    }
}
