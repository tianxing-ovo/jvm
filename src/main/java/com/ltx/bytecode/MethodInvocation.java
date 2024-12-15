package com.ltx.bytecode;

/**
 * 方法调用
 *
 * @author tianxing
 */
public class MethodInvocation {
    public static void test4() {
    }

    public static void main(String[] args) {
        // new(分配内存) -> dup(复制引用) -> invokespecial(初始化对象,消耗掉栈顶的一个引用作为构造函数的隐含参数this) -> 后续操作灵活性(设置对象属性/调用对象方法)
        MethodInvocation methodInvocation = new MethodInvocation();
        // aload_1 -> invokespecial
        methodInvocation.test1();
        // aload_1 -> invokevirtual
        methodInvocation.test2();
        // aload_1 -> invokevirtual
        methodInvocation.test3();
        // invokestatic
        MethodInvocation.test4();
        // aload_1 -> pop -> invokestatic
        // (aload_1 -> pop): 使用对象引用调用静态方法,产生多余的虚拟机指令
        methodInvocation.test4();
    }

    private void test1() {
    }

    public final void test2() {
    }

    public void test3() {
    }
}
