package exercise;

/**
 * 从字节码角度分析<init>
 */
public class Demo4 {
    // ldc "s1" -> putfield
    private String a = "s1";

    {
        // 可以先赋值再声明但不能使用
        // bipush 20 -> putfield
        b = 20;
    }

    // bipush 10 -> putfield
    private int b = 10;

    {
        // ldc "s2" -> putfield
        a = "s2";
    }

    public Demo4(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4("s3", 30);
        // a = "s3"
        System.out.println(demo4.a);
        // b = 30
        System.out.println(demo4.b);
    }
}
