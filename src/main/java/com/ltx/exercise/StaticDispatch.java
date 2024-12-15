package com.ltx.exercise;

/**
 * 静态分派: 依赖静态类型来决定方法执行版本的分派动作
 *
 * @author tianxing
 */
public class StaticDispatch {

    public static void main(String[] args) {
        // Human: "静态类型"(Static Type)/"外观类型"(Apparent Type)
        // Man: "实际类型"(Actual Type)/"运行时类型"(Runtime Type)
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        // hello,guy!
        sr.sayHello(man);
        // hello,guy!
        sr.sayHello(woman);
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static abstract class Human {
    }

    public static class Man extends Human {
    }

    public static class Woman extends Human {
    }
}
