package entity;

import java.util.Objects;

public class Person {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Object中比较内存地址是否相等
     */
    @Override
    public boolean equals(Object o) {
        // 比较内存地址是否相等
        if (this == o) return true;
        // 比较类型是否相同
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        // 比较内容是否相同
        return age == person.age && Objects.equals(name, person.name);
    }

    /**
     * Object中根据内存地址生成哈希码
     */
    @Override
    public int hashCode() {
        // 根据对象的属性生成哈希码
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
