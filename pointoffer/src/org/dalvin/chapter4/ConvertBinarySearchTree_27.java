package org.dalvin.chapter4;

import org.dalvin.chapter2.TreeNode;

/**
 * Created by qiudeyang on 08/02/17.
 */
//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class ConvertBinarySearchTree_27 {
    //解法太精辟，需要耐心分析。我们在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，
    // 原先指向右子结点的指针调整为链表中指向后一个结点指针。
    public static TreeNode convertBinarySearchTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //用于保存处理过程中的双向链表的尾节点
        TreeNode[] lastNode = new TreeNode[1];
        convertTreeNode(root, lastNode);
        //找到双向链表的头结点
        TreeNode head = lastNode[0];
        while (head != null && head.left != null) {
            head = head.left;
        }
        return head;
    }
    //root当前的根结点，lastNode当前处理好的双向链表的尾节点，
    public static void convertTreeNode(TreeNode root, TreeNode[] lastNode) {
        if (root != null) {
            //如果右左子树，就先处理左子树
            if (root.left != null) {
                convertTreeNode(root.left, lastNode);
            }
            // 将当前结点的前驱指向已经处理好的双向链表（由当前结点的左子树构成）的尾结点
            root.left = lastNode[0];
            // 如果左子树转换成的双向链表不为空，设置尾结点的后继
            if (lastNode[0] != null) {
                lastNode[0].right = root;
            }
            // 记录当前结点为尾结点
            lastNode[0] = root;
            // 处理右子树
            if (root.right != null) {
                convertTreeNode(root.right, lastNode);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(8);
        root.right = new TreeNode(14);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(16);
        convertBinarySearchTree(root);
    }
}
