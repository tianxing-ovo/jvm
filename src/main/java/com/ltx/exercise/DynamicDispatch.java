package com.ltx.exercise;

/**
 * 动态分派: 运行期根据实际类型确定方法执行版本的分派过程
 *
 * @author tianxing
 */
public class DynamicDispatch {
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        // man say hello
        man.sayHello();
        // woman say hello
        woman.sayHello();
        man = new Woman();
        // woman say hello
        man.sayHello();
    }

    public static abstract class Human {
        protected abstract void sayHello();
    }

    public static class Man extends Human {
        @Override
        protected void sayHello() {
            System.out.println("man say hello");
        }
    }

    public static class Woman extends Human {
        @Override
        protected void sayHello() {
            System.out.println("woman say hello");
        }
    }
}
