package test;

/**
 * 栈内存溢出
 */
public class StackMemoryOverflow {

    private static int count = 0;

    public static void main(String[] args) {
        try {
            method();
        } catch (StackOverflowError e) {
            System.out.println(count);
        }
    }

    /**
     * 栈帧过多导致栈内存溢出
     */
    @SuppressWarnings("InfiniteRecursion")
    public static void method() {
        count++;
        method();
    }
}
