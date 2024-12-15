package com.ltx.exercise;

import com.ltx.entity.Person;
import com.ltx.entity.Student;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 演示重写equals()方法就必须重写hashcode()方法的原因
 * Student: 只重写equals()方法
 * Person: 重写equals()方法和hashCode()方法
 *
 * @author tianxing
 */
public class EqualsAndHashCode {

    public static Student s1 = new Student("David", 18);
    public static Student s2 = new Student("David", 18);
    public static Person p1 = new Person("Alice", 20);
    public static Person p2 = new Person("Alice", 20);
    public static HashSet<Student> studentSet = new HashSet<>();
    public static HashSet<Person> personSet = new HashSet<>();
    public static HashMap<Student, String> studentMap = new HashMap<>();
    public static HashMap<Person, String> personMap = new HashMap<>();

    public static void main(String[] args) {
        test();
        // 测试对HashSet的影响
        testForHashSet();
        // 测试对HashMap的影响
        testForHashMap();
    }

    /**
     * equals()方法返回true,hashcode()方法也必须返回true
     */
    public static void test() {
        // true
        System.out.printf("s1.equals(s2)\t%b\n", s1.equals(s2));
        // false
        System.out.printf("s1.hashCode() == s2.hashCode()\t%b\n", s1.hashCode() == s2.hashCode());
        // true
        System.out.printf("p1.equals(p2)\t%b\n", p1.equals(p2));
        // true
        System.out.printf("p1.hashCode() == p2.hashCode()\t%b\n", p1.hashCode() == p2.hashCode());
    }

    /**
     * 只重写equals()方法,不重写hashcode()方法,导致HashSet无法去重
     */
    public static void testForHashSet() {
        studentSet.add(s1);
        studentSet.add(s2);
        // studentSet = [Student{name='张三', age=18}, Student{name='张三', age=18}]
        // 原因: key的hashCode不同 -> 分配到不同的桶(bucket)中
        System.out.println("studentSet = " + studentSet);
        personSet.add(p1);
        personSet.add(p2);
        // personSet = [Person{name='张三', age=18}]
        // 原因: key的hashCode相同 -> 分配到同一个桶(bucket)中 -> equals()方法返回true -> 不会添加相同对象
        System.out.println("personSet = " + personSet);
    }

    /**
     * 只重写equals()方法,不重写hashcode()方法,导致HashMap相同key有多个value
     */
    private static void testForHashMap() {
        studentMap.put(s1, "s1");
        studentMap.put(s2, "s2");
        // studentMap = {Student{name='David', age=18}=s1, Student{name='David', age=18}=s2}
        // 原因: key的hashCode不同 -> 分配到不同的桶(bucket)中 -> 相同key有多个value
        System.out.println("studentMap = " + studentMap);
        personMap.put(p1, "p1");
        personMap.put(p2, "p2");
        // personMap = {Person{name='Alice', age=20}=p2}
        // 原因: key的hashCode相同 -> 分配到同一个桶(bucket)中 -> equals()方法返回true -> 覆盖旧的value
        System.out.println("personMap = " + personMap);
    }
}
