package org.dalvin.chapter6;

import org.dalvin.chapter2.TreeNode;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class BalancedBinaryTree_39 {
    public static boolean isBalancedBinaryTree(TreeNode root) {
        return depth(root) != -1;
    }

    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = depth(root.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = depth(root.right);
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        System.out.println(isBalancedBinaryTree(root));
    }
}
