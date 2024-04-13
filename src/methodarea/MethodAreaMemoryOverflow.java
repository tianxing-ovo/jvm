package methodarea;

import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * 方法区(元空间)内存溢出
 */
public class MethodAreaMemoryOverflow extends ClassLoader {

    /**
     * 参数设置: -XX:MaxMetaspaceSize=10m
     */
    public static void main(String[] args) {
        // 生成类的二进制字节码,0表示默认的类版本和类访问标志
        ClassWriter classWriter = new ClassWriter(0);
        MethodAreaMemoryOverflow classLoader = new MethodAreaMemoryOverflow();
        int count = 0;
        try {
            for (int i = 0; i < 10000; i++, count++) {
                String className = "Class" + i;
                // Java版本,访问修饰符,类名,包名,父类名,接口名数组
                classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, className, null, "java/lang/Object", null);
                // 生成字节码
                byte[] bytes = classWriter.toByteArray();
                // 执行类加载
                classLoader.defineClass(className, bytes, 0, bytes.length);
            }
        } catch (OutOfMemoryError e) {
            // java.lang.OutOfMemoryError: Metaspace
            e.printStackTrace(System.err);
            // count = 745
            System.out.println(count);
        }
    }
}
