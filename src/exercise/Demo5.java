package exercise;

/**
 * 从字节码角度分析方法调用
 */
public class Demo5 {

    private void test1() {

    }

    public final void test2() {

    }

    public void test3() {

    }

    public static void test4() {

    }

    public static void main(String[] args) {
        // new(分配内存) -> dup(复制引用) -> invokespecial(初始化对象,消耗掉栈顶的一个引用作为构造函数的隐含参数this) -> 后续操作灵活性(设置对象属性/调用对象方法)
        Demo5 demo5 = new Demo5();
        // aload_1 -> invokespecial
        demo5.test1();
        // aload_1 -> invokevirtual
        demo5.test2();
        // aload_1 -> invokevirtual
        demo5.test3();
        // aload_1 -> pop -> invokestatic
        // (aload_1 -> pop): 使用对象引用调用静态方法,产生多余的虚拟机指令
        demo5.test4();
        // invokestatic
        Demo5.test4();
    }
}
