package com.ltx.bytecode;

/**
 * finally原理
 *
 * @author tianxing
 */
@SuppressWarnings({"finally", "ReturnInsideFinallyBlock", "NumericOverflow", "divzero"})
public class Finally {
    public static void main(String[] args) {
        // i = 10
        System.out.println("i = " + returnInTry());
        // j = 20
        System.out.println("j = " + returnInFinally());
    }


    /**
     * try中return
     * 局部变量表: [i,j,Throwable]
     * 执行顺序: bipush 10 -> istore_0 -> iload_0 -> istore_1 -> bipush 20 -> istore_0 -> iload_1 -> ireturn
     *
     * @return int
     */
    public static int returnInTry() {
        // bipush 10 -> istore_0(i=10)
        int i = 10;
        try {
            // 返回值已经固定为10
            // iload_0(10) -> istore_1(j=10) -> iload_1(10) -> ireturn
            return i;
        } finally {
            // bipush 20 -> istore_0(i=20)
            i = 20;
        }
    }

    /**
     * finally中return
     *
     * @return int
     */
    public static int returnInFinally() {
        try {
            System.out.println(1 / 0);
            return 10;
        } finally {
            // 不会生成athrow指令
            return 20;
        }
    }
}
