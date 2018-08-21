package win.elegentjs.datastructor.binarytree;

/**
 * 二叉搜索树的实现
 */
public class BinarySearchTree implements Tree {

    // 根节点
    private Node root;

    /**
     * 默认构造函数
     */
    public BinarySearchTree() {
    }

    public BinarySearchTree(int rootData) {
        this.root = new Node(rootData);
    }

    @Override
    public Node find(int key) {
        Node current = root;
        Node target = null;

        while (current != null) {
            if (current.data == key) {
                target = current;
                break;
            }

            if (key < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return target;
    }


    /**
     * 前序遍历
     */
    public void preOrder(Node current) {
        if (current == null) {
            return;
        }

        System.out.print(current.data + " ");

        preOrder(current.left);
        preOrder(current.right);
    }


    /**
     * 中序遍历
     */
    public void infixOrder(Node current) {
        if (current == null) {
            return;
        }

        infixOrder(current.left);
        System.out.print(current.data + " ");
        infixOrder(current.right);
    }

    /**
     * 后序遍历
     */
    public void postOrder(Node current) {
        if (current == null) {
            return;
        }

        postOrder(current.left);
        postOrder(current.right);

        System.out.print(current.data + " ");
    }



    @Override
    public boolean add(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
            return true;
        }


        Node currentNode = root;
        Node pNode;

        while (true) {
            pNode = currentNode;

            if (key < currentNode.data) {
                currentNode = currentNode.left;

                if (currentNode == null) {
                    pNode.left = newNode;
                    return true;
                }

                continue;
            }

            currentNode = currentNode.right;

            if (currentNode == null) {
                pNode.right = newNode;
                return true;
            }
        }

    }

    /**
     * 查找最下的元素
     * @return
     */
    public Node findMin() {
        Node current = root;
        Node min = null;

        while (true) {
            if (current.left != null) {
                current = current.left;
                continue;
            }

            min = current;
            break;
        }

        return min;
    }

    /**
     * 查找最大的元素
     * @return
     */
    public Node findMax() {
        Node current = root;
        Node max = null;

        while (true) {
            if (current.right != null) {
                current = current.right;
                continue;
            }

            max = current;
            break;
        }

        return max;
    }


    @Override
    public boolean del(int key) {
        Node current = root;
        Node pNode = null;
        boolean isLeftLeaf = false;

        while (current != null) {
            // 找到了目标节点
            if (key == current.data) {
                break;
            }

            pNode = current;

            if (key < current.data) {
                current = current.left;
                isLeftLeaf = true;
            } else {
                current = current.right;
                isLeftLeaf = false;
            }
        }

        // 未找到目标节点
        if (current == null) {
            return false;
        }

        // 是叶子节点
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftLeaf) {
                    pNode.left = null;
                } else {
                    pNode.right = null;
                }
            }

            return true;
        }

        // 仅有一个子节点（并且是右子节点）
        if (current.left == null && current.right != null) {
            if (current == root) {
                root = current.right;
            } else {
                if (isLeftLeaf) {
                    pNode.left = current.right;
                } else {
                    pNode.right = current.right;
                }
            }

            return true;
        }

        // 仅有一个子节点（并且是左子节点）
        if (current.left != null && current.right == null) {
            if (current == root) {
                root = current.left;
            } else {
                if (isLeftLeaf) {
                    pNode.left = current.left;
                } else {
                    pNode.right = current.left;
                }
            }

            return true;
        }

        // 该节点有两个子节点
        // 处理较复杂：1. 需要找出比本节点大的第一个节点，搜索算法：在本节点的右子树中查找，如果右子节点无左子树，则该节点就是目标节点
        // 如果右子节点有左子树，则一直在子树上查找，直到左子节点为null,该节点就是目标节点
        // 找到的目标节点如果是叶子节点，直接用该节点替换待删除节点
        // 如果目标节点也有子节点需要分情况处理：
        // 1：目标节点是待删除的右节点，直接替换删除节点
        // 2: 目标节点是待删除子树的左节点，目标节点的右子树需要连接到目标节点的双亲，用目标节点替换待删除节点


        Node target;

        Node node = current.right;

        // 搜索的待替换节点是待删除节点的右子节点
        if (node.left == null) {
            target = node;

            if (isLeftLeaf) {
                pNode.left = target;
                target.left = current.left;
            } else {
                pNode.right = target;
                target.left = current.left;
            }

            return true;

        } else { // 搜索的待替换节点是待删除节点的左子节点
            Node searchLeft = node.left;
            Node searchLeftP = null;

            while (searchLeft != null) {
                searchLeftP = searchLeft;

               if (searchLeft.left == null) {
                   break;
               }

               searchLeft = searchLeft.left;
            }


            // 判断节点是否有右子树
            if (searchLeft.right != null) {
                searchLeftP.right = searchLeft.right;
            }

            searchLeftP.left = null;

            if (isLeftLeaf) {
                pNode.left = searchLeft;
                searchLeft.left = current.left;
            } else {
                pNode.right = searchLeft;
                searchLeft.left = current.left;
            }

            return true;


        }

    }


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.add(5);
        tree.add(4);
        tree.add(6);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(8);
        tree.add(1);
        tree.add(9);
        tree.add(0);

        System.out.println("前序遍历：");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("中序遍历：");
        tree.infixOrder(tree.root);
        System.out.println();

        System.out.println("后序遍历：");
        tree.postOrder(tree.root);
        System.out.println();

        Node min = tree.findMin();
        System.out.println("最小元素：" + min.data);

        Node max = tree.findMax();
        System.out.println("最大元素：" + max.data);

        tree.del(4);

        System.out.println("前序遍历：");
        tree.preOrder(tree.root);
        System.out.println();

    }
}
