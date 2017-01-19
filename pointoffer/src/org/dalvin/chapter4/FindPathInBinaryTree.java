package org.dalvin.chapter4;

import org.dalvin.chapter2.TreeNode;

import java.util.Stack;

/**
 * Created by qiudeyang on 19/01/17.
 */
//只判断存不存在这样的路径。
public class FindPathInBinaryTree {
    public static boolean result = false;
    public static boolean findPathInBinaryTree(TreeNode root, int target) {
        if (root == null){
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int currentSum = 0;
        findPath(root,target,stack,currentSum);
        return result;
    }

    public static void findPath(TreeNode root,int target,Stack<Integer> stack,int currentSum){
        currentSum += root.val;
        stack.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (currentSum==target && isLeaf){
            result = true;
        }
        if (root.left != null){
            findPath(root.left,target,stack,currentSum);
        }
        if (root.right != null){
            findPath(root.right,target,stack,currentSum);
        }
        stack.pop();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(3);
        System.out.println(findPathInBinaryTree(root, 19));
    }
}
