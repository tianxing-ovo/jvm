package exercise;

/**
 * 从字节码角度分析
 */
public class Demo2 {
    public static void main(String[] args) {
        int i = 0;
        int x = 0;
        while (i < 10) {
            // iload_2 -> iinc 2, 1 -> istore_2
            x = x++;
            i++;
        }
        // x = 0
        System.out.println(x);
    }
}
