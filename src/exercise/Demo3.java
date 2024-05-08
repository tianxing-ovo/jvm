package exercise;

/**
 * 从字节码角度分析<cinit>
 */
public class Demo3 {

    // bipush 10 -> putstatic
    static int i = 10;

    // bipush 20 -> putstatic
    static {
        i = 20;
    }

    // bipush 30 -> putstatic
    static {
        i = 30;
    }
}
