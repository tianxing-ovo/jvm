package exercise;


public class Demo7 {
    public static void main(String[] args) {
        int result = test();
        // result = 10
        System.out.println(result);
    }

    public static int test() {
        int i = 10;
        try {
            // 返回值已经固定为10
            return i;
        } finally {
            i = 20;
        }
    }
}
