package exercise;


/**
 * 从字节码角度分析finally中return
 */
@SuppressWarnings({"divzero", "finally", "ReturnInsideFinallyBlock", "UnreachableCode", "NumericOverflow"})
public class Demo6 {
    public static void main(String[] args) {
        int result = test();
        // result = 20
        System.out.println(result);
    }

    public static int test() {
        try {
            // finally中出现了return,会吞掉异常
            System.out.println(1 / 0);
            return 10;
        } finally {
            return 20;
        }
    }
}
