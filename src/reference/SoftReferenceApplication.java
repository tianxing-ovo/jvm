package reference;


import constant.Constant;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 软引用应用
 */
public class SoftReferenceApplication {

    /**
     * 参数设置: -Xmx20m
     */
    public static void main(String[] args) {
        // List --> SoftReference --> byte[]
        List<SoftReference<byte[]>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new SoftReference<>(new byte[Constant._4MB]));
        }
        list.forEach(softReference -> System.out.println(softReference.get()));
    }
}
