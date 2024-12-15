package com.ltx.entity;

import java.util.Objects;

/**
 * 重写equals()方法和hashCode()方法
 *
 * @author tianxing
 */
public class Person {

    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    /**
     * Object中的equals()方法: 比较内存地址是否相等
     *
     * @param obj 要与之比较的对象
     * @return 相同返回true;否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        // 比较内存地址是否相等
        if (this == obj) {
            return true;
        }
        // 比较类型是否相同
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Person person = (Person) obj;
        // 比较内容是否相同
        return age == person.age && Objects.equals(name, person.name);
    }


    /**
     * Object中的hashCode()方法: 根据内存地址生成哈希码
     *
     * @return 对象的哈希码值
     */
    @Override
    public int hashCode() {
        // 根据对象的属性值生成哈希码
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
