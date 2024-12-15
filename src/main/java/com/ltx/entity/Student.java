package com.ltx.entity;

import java.util.Objects;

/**
 * 只重写equals()方法
 *
 * @author tianxing
 */
public class Student {

    private final String name;
    private final int age;

    public Student(String name, int age) {
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
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
