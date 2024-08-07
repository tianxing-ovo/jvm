package exercise;

import java.io.IOException;

/**
 * 使用HSDB探究多态原理
 */
public class Polymorphic {

    /**
     * 参数设置: -XX:-UseCompressedOops -XX:-UseCompressedClassPointers
     */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) throws IOException {
        Animal animal = new Dog();
        animal.eat();
        System.out.println(animal);
        animal = new Cat();
        animal.eat();
        System.out.println(animal);
        System.in.read();
    }
}

abstract class Animal {
    public abstract void eat();

    @Override
    public String toString() {
        return String.format("我是%s", this.getClass().getSimpleName());
    }
}

class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}

class Cat extends Animal {

    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
