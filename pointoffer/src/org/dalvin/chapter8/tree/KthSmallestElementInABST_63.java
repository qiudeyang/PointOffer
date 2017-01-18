package org.dalvin.chapter8.tree;

import org.dalvin.chapter2.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by qiudeyang on 18/01/17.
 */
public class KthSmallestElementInABST_63 {
    public static TreeNode kthSmallestElementInABST(TreeNode root, int k) {
        List<Integer> list = midOrderTraversal(root);
        return new TreeNode(list.get(k - 1));
    }
    public static List<Integer> midOrderTraversal(TreeNode root){
        List<Integer> list = new LinkedList<Integer>();
        if (root == null){
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            current = current.right;
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(kthSmallestElementInABST(root,5));
    }
}
