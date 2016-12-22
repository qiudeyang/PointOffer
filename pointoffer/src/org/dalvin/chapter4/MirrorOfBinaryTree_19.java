package org.dalvin.chapter4;

import org.dalvin.chapter2.TreeNode;

/**
 * Created by qiudeyang on 21/12/16.
 */
public class MirrorOfBinaryTree_19 {
    public static void mirrorOfBinaryTree(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            mirrorOfBinaryTree(root.left);
        }
        if (root.right != null){
            mirrorOfBinaryTree(root.right);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        mirrorOfBinaryTree(root);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
    }
}
