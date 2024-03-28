package test;

/**
 * 字符串常量池
 */
public class StringPool {


    /**
     * StringPool: ["a","b","ab"]
     */
    public static void main(String[] args) {
        // 懒加载,用到时才会把符号(a/b/ab)变成字符串对象("a"/"b"/"ab")放入字符串常量池中
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        // 等价于new StringBuilder().append("a").append("b").toString() = new String("ab")
        String s4 = s1 + s2;
        // javac在编译期间的优化,结果已经在编译期间确定为"ab"
        String s5 = "a" + "b";
        // false
        System.out.println(s3 == s4);
        // true
        System.out.println(s3 == s5);
    }
}
