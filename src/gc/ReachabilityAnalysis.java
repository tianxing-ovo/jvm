package gc;

/**
 * 可达性分析法解决循环引用问题
 */
public class ReachabilityAnalysis {
    public static void main(String[] args) {
        Node nodeA = new Node();
        Node nodeB = new Node(nodeA);
        nodeA.next = nodeB;
        // 无法从任何GC Roots通过引用链路到达nodeA和nodeB,因此可以被垃圾回收
        nodeA = null;
        nodeB = null;
    }
}
