package win.elegentjs.datastructor.tree;

/**
 * 红黑树
 * 为什么需要红黑树
 *  二叉搜索树随机插入的情况下树总体保持平衡，即左子树节点数量大致等于右子树节点数量
 *  在该情况下查找，插入，删除的时间复杂度为O（logN）
 *  而如果插入时是以顺序插入时，则二叉树退化为普通的链表，查找，插入，删除时间复杂度为O(logN)
 *
 *  所以需要红黑树，它能自动调整二叉树，保持树平衡
 */
public class RedBlackTree {

}



class RBNode {

    public int name;

    public boolean isRed;

    public RBNode left;

    public RBNode right;

    public RBNode pRBNode;


    public RBNode(int name, boolean isRed) {
        this.name = name;
        this.isRed = isRed;
    }

    @Override
    public String toString() {
        return "RBNode{" +
                "name=" + name +
                ", isRed=" + isRed +
                '}';
    }
}
