package org.dalvin.chapter3;

import org.dalvin.chapter2.TreeNode;

/**
 * Created by qiudeyang on 21/12/16.
 */
public class SubTree {
    public static boolean isSubTree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result = tree1HasTree2(root1, root2);
            }
            if (!result) {
                result = isSubTree(root1.left, root2);
            }
            if (!result) {
                result = isSubTree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean tree1HasTree2(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return tree1HasTree2(root1.left, root2.left) && tree1HasTree2(root1.right, root2.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);
        System.out.println(isSubTree(root1, root2));
    }
}
