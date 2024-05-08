package exercise;

/**
 * 从字节码角度分析
 */
public class Demo1 {
    public static void main(String[] args) {
        int a = 10;
        // a++: iload_1 -> iinc 1, 1
        // ++a: iinc 1, 1 -> iload_1
        // a--: iload_1 -> iinc 1, -1
        int b = a++ + ++a + a--;
        // 10 + 1 + 1 -1 = 11
        System.out.println(a);
        // 10 + 12 + 12 = 34
        System.out.println(b);
    }
}
