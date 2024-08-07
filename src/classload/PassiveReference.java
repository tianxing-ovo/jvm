package classload;

/**
 * 被动引用
 */
public class PassiveReference {

    /**
     * 参数设置: -XX:+TraceClassLoading
     */
    public static void main(String[] args) {
        // 通过子类引用父类的静态字段只会触发父类的初始化(只有直接定义这个字段的类才会被初始化)
        System.out.println(SubClass.value);
        // 通过数组定义来引用类不会触发类的初始化
        SuperClass[] sca = new SuperClass[10];
        // 引用final常量不会触发类的初始化
        System.out.println(ConstClass.HELLO_WORLD);
    }
}

class SuperClass {

    public static int value = 123;

    static {
        System.out.println("SuperClass init");
    }
}

class SubClass extends SuperClass {

    static {
        System.out.println("SubClass init");
    }
}

class ConstClass {
    public static final String HELLO_WORLD = "hello world";

    static {
        System.out.println("ConstClass init");
    }
}
