package org.dalvin.chapter8.tree;

import org.dalvin.chapter2.TreeNode;

/**
 * Created by qiudeyang on 27/12/16.
 */
public class NextTreeNode_58 {
    public static TreeNode nextTreeNode(TreeNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeNode pNext = null;
        if (pNode.right != null) {
            TreeNode temp1 = pNode.right;
            while (temp1.left != null) {
                temp1 = temp1.left;
            }
            pNext = temp1;
        } else if (pNode.parent != null) {
            TreeNode pChild = pNode;
            TreeNode pParent = pNode.parent;
            while (pParent != null && pChild == pParent.right) {
                pChild = pParent;
                pParent = pParent.parent;
            }
            pNext = pParent;
        }
        return pNext;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(nextTreeNode(root.left).val);
    }
}
