package win.elegentjs.datastructor.tree;



/**
 * 二叉搜索树
 */
public class BinarySearchTree {


    public Node root;


    /**
     * 插入节点，找到目标节点位置，执行插入
     * 从根开始比较，如果比当前节点小，则遍历左子树，如果比当前节点大则遍历右子树，直到子节点为空，插入到合适位置
     *
     * @param nodeName
     */
    public void add(int nodeName) {
        if (root == null) {
            root = new Node(nodeName);
            return;
        }

        Node current = root;
        Node pNode = null;

        while (current != null) {
            pNode = current;

            if (nodeName < current.getNodeName()) {
                current = current.getLeftChild();

                if (current == null) {
                    pNode.setLeftChild(new Node(nodeName, pNode));
                    break;
                }
            } else {
                current = current.getRightChild();

                if (current == null) {
                    pNode.setRightChild(new Node(nodeName, pNode));
                    break;
                }
            }
        }

    }

    /**
     * 删除二叉搜索树子节点
     *
     * 为了维护二叉搜索树的特性，即左子树比节点小，右子树比节点大，删除比较复杂
     *
     * 1）该节点是叶子节点
     *  最简单，只要删除该节点的父节点对该节点的引用即可
     * 2）该节点只有一个子节点
     *  也简单，讲该节点的父节点指向它的子节点
     *
     * 3）该节点有两个子节点
     *  此时的删除操作节点操作需要找到紧靠的后续节点来替代它
     *      1）如果紧靠的节点是右子树的第一个节点（即该节点没有左子树），比较简单直接将待删除节点的父节点重新指向该节点
     *      2)..
     *
     *
     * @param nodeName
     */
    public void del(int nodeName) {
        Node node = search(nodeName);

        if (node == null) {
            throw new IllegalStateException("cannot find node for nodeName : " + nodeName);
        }

        if (node.getLeftChild() == null && node.getRightChild() == null) {
            Node pNode = node.getpNode();

            // pNode为空，说明当前节点是root节点
            if (pNode == null) {
                root = null;
                return;
            }

            // 是父节点的左节点
            if (pNode.getLeftChild() == node) {
                pNode.setLeftChild(null);
            } else {
                pNode.setRightChild(null);
            }
        } else if (node.getLeftChild() == null && node.getRightChild() != null) {
            Node pNode = node.getpNode();

            // pNode为空，说明当前节点是root节点
            if (pNode == null) {
                root = node.getRightChild();
                return;
            }

            // 是父节点的左节点
            if (pNode.getLeftChild() == node) {
                pNode.setLeftChild(node.getRightChild());
            } else {
                pNode.setRightChild(node.getRightChild());
            }
        }  else if (node.getRightChild() == null && node.getLeftChild() != null) {
            Node pNode = node.getpNode();

            // pNode为空，说明当前节点是root节点
            if (pNode == null) {
                root = node.getLeftChild();
                return;
            }

            // 是父节点的左节点
            if (pNode.getLeftChild() == node) {
                pNode.setLeftChild(node.getLeftChild());
            } else {
                pNode.setRightChild(node.getLeftChild());
            }
        } else { // 待删除节点有两个子节点
            Node pNode = node.getpNode();
            Node nextNode = findNextNode(node);

            // nextNode 为待删除节点右子树的第一个节点，则比较简单，直接将父节点指向该节点
            if (node.getRightChild() == nextNode) {
                nextNode.setLeftChild(node.getLeftChild());
                // 是父节点的左节点
                if (pNode.getLeftChild() == node) {
                    pNode.setLeftChild(nextNode);
                } else {
                    pNode.setRightChild(nextNode);
                }
            } else {
                // 较复杂，需要做以下操作：
                // 1）后继节点的父节点左子节点指向后继节点右子节点
                nextNode.getpNode().setLeftChild(nextNode.getRightChild());
                // 2）待删除节点的父节点指向后继节点，后继节点的左节点为待删除节点的左节点，后继节点的右节点为待删除节点的右节点
                nextNode.setLeftChild(node.getLeftChild());
                nextNode.setRightChild(node.getRightChild());
                // 是父节点的左节点
                if (pNode.getLeftChild() == node) {
                    pNode.setLeftChild(nextNode);
                } else {
                    pNode.setRightChild(nextNode);
                }
            }
        }
    }

    /**
     * 查找节点的紧靠的下一个节点，即右子树的左左侧下方的节点
     * @param node
     * @return
     */
    private Node findNextNode(Node node) {
        Node next = node.getRightChild();
        Node target = next;

        while (next != null) {
            if (next.getLeftChild() == null) {
                target = next;
                break;
            }

            next = next.getLeftChild();
        }

        return target;
    }

    // 中序遍历
    public void infixOrder(Node node) {
        if (node != null) {
            infixOrder(node.getLeftChild());
            System.out.println(node);
            infixOrder(node.getRightChild());
        }
    }

    // 前序遍历
    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    // 后序遍历
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.println(node);
        }
    }

    /**
     * 查找最小项，即最左边的节点
     * @return
     */
    public Node findMin() {
        Node current = root;
        Node target = current;
        while (current != null) {
            if (current.getLeftChild() == null) {
                target = current;
                break;
            }

            current = current.getLeftChild();
        }

        return target;
    }


    /**
     * 查找最大项，即最右边的节点
     * @return
     */
    public Node findMax() {
        Node current = root;
        Node target = current;

        while (current != null) {
            if (current.getRightChild() == null) {
                target = current;
                break;
            }

            current = current.getRightChild();
        }

        return target;
    }

    /**
     * 便利查找目标元素，根据二叉搜索树的特性，左子树的节点都比当前节点小，
     * 右子树的节点都比当前大，所以找出目标元素的时间复杂度为logN
     * @param nodeName
     * @return
     */
    public Node search(int nodeName) {
        Node current = root;
        Node target = null;
        while (current != null) {
            int cNodeName = current.getNodeName();
            if (nodeName == cNodeName) {
                target = current;
                break;
            }

            if (nodeName < cNodeName) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }

        }

        return target;
    }
}


class Main {
    public static void main(String[] args) {
        BinarySearchTree binaryTree = new BinarySearchTree();

        binaryTree.add(50);
        binaryTree.add(25);
        binaryTree.add(60);
        binaryTree.add(15);
        binaryTree.add(35);
        binaryTree.add(5);
        binaryTree.add(20);
        binaryTree.add(30);
        binaryTree.add(40);
        binaryTree.add(31);

        binaryTree.infixOrder(binaryTree.root);

        System.out.println("===================");

        System.out.println("max : " + binaryTree.findMax());
        System.out.println("min : " + binaryTree.findMin());

        binaryTree.del(25);

        binaryTree.infixOrder(binaryTree.root);

    }
}


/**
 * 二叉树节点
 */
class Node  {

    private int nodeName;

    private Node pNode;

    private Node leftChild;

    private Node rightChild;

    public Node(int nodeName) {
        this.nodeName = nodeName;
    }

    public Node(int nodeName, Node pNode) {
        this.nodeName = nodeName;
        this.pNode = pNode;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node getpNode() {
        return pNode;
    }

    public void setpNode(Node pNode) {
        this.pNode = pNode;
    }

    public int getNodeName() {
        return nodeName;
    }

    public void setNodeName(int nodeName) {
        this.nodeName = nodeName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeName='" + nodeName + '\'' +
                '}';
    }
}

