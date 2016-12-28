package org.dalvin.chapter8.tree;

import org.dalvin.chapter2.TreeNode;

/**
 * Created by qiudeyang on 27/12/16.
 */
public class SymmetricTree_59 {
    public static boolean isSymmetricTree(TreeNode root){
        if (root == null){
            return true;
        }
        return helper(root.left,root.right);
    }
    public static boolean helper(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return helper(left.left,right.right) && helper(left.right,right.left);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(isSymmetricTree(root));
    }
}
