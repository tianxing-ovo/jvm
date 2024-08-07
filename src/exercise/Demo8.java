package exercise;

import entity.Person;
import entity.Student;

import java.util.HashSet;

/**
 * 演示重写equals()方法必须重写hashcode()方法的原因
 */
public class Demo8 {

    static Student s1 = new Student("张三", 18);
    static Student s2 = new Student("张三", 18);
    static Person p1 = new Person("张三", 18);
    static Person p2 = new Person("张三", 18);
    static HashSet<Student> set1 = new HashSet<>();
    static HashSet<Person> set2 = new HashSet<>();


    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * equals()方法返回true,hashcode()方法也必须返回true
     */
    public static void test1() {
        // true
        System.out.println(s1.equals(s2));
        // false
        System.out.println(s1.hashCode() == s2.hashCode());
        // true
        System.out.println(p1.equals(p2));
        // true
        System.out.println(p1.hashCode() == p2.hashCode());
    }

    /**
     * 只重写equals()方法,不重写hashcode()方法,导致HashSet/HashMap无法去重
     */
    public static void test2() {
        set1.add(s1);
        set1.add(s2);
        // [Student{name='张三', age=18}, Student{name='张三', age=18}]
        System.out.println(set1);
        set2.add(p1);
        set2.add(p2);
        // [Person{name='张三', age=18}]
        System.out.println(set2);
    }
}
