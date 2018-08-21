package win.elegentjs.datastructor.binarytree;

/**
 * 定义二叉树的节点
 */
public class Node {

    // 节点数据
    protected int data;

    // 左子节点
    protected Node left;

    // 右子节点
    protected Node right;

    /**
     * 构造函数：左子节点和右子节点引用都为null
     * @param data
     */
    public Node(int data) {
        this(data, null, null);
    }

    /**
     * 构造函数：可指定左子节点和右子节点
     * @param data
     * @param left
     * @param right
     */
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    // 打印节点内容
    public void display() {
        System.out.println(data);
    }

}
