package com.ltx.gc;


import com.ltx.constant.Constant;

import java.util.ArrayList;
import java.util.List;

/**
 * GC分析
 *
 * @author tianxing
 */
public class Analysis {

    /**
     * 参数设置: -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:+PrintGCDetails -verbose:gc
     * new generation: 新生代
     * tenured generation: 老年代
     * DefNew: 2012K->625K(9216K): 2012K(eden存活对象+from存活对象),625K(from存活对象),9216K(eden+from)
     * 8607K->8286K(19456K): 8607K(eden存活对象+from存活对象+老年代存活对象),8286K(from存活对象+老年代存活对象),19456K(eden+from+老年代)
     */
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();
        // 触发minor gc,将Eden中的部分存活对象复制到幸存区to中
        list.add(new byte[Constant._7MB]);
        // 不触发minor gc
        list.add(new byte[Constant._512KB]);
        // 触发minor gc,将Eden中的大对象直接晋升到老年代中
        list.add(new byte[Constant._512KB]);
        System.out.println(list);
    }
}
