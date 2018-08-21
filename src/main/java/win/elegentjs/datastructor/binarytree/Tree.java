package win.elegentjs.datastructor.binarytree;

/**
 * 树的定义（可执行的操作）
 */
public interface Tree {

    // 查找指定节点
    Node find(int key);

    // 新增节点
    boolean add(int key);

    // 删除节点
    boolean del(int key);


}
