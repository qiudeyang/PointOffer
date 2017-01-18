package org.dalvin.chapter8.tree;

import org.dalvin.chapter2.TreeNode;
import java.util.Stack;

/**
 * Created by qiudeyang on 18/01/17.
 */
//按之字形打印二叉树
public class PrintZig_61 {
    public static void printZig(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(root);
        int count = 1;
        while (!stack1.isEmpty() || !stack2.isEmpty()){
            if (count == 1){
                while (!stack1.isEmpty()){
                    TreeNode temp = stack1.pop();
                    System.out.print(temp.val+"\t");
                    if (temp.left != null){
                        stack2.push(temp.left);
                    }
                    if (temp.right != null){
                        stack2.push(temp.right);
                    }
                }
                System.out.println();  //换行
                count = 1 - count;
            }
            if (count == 0){
                while (!stack2.isEmpty()){
                    TreeNode temp = stack2.pop();
                    System.out.print(temp.val+"\t");
                    if (temp.right != null){
                        stack1.push(temp.right);
                    }
                    if (temp.left != null){
                        stack1.push(temp.left);
                    }
                }
                System.out.println();
                count = 1 - count;
            }
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.left = new TreeNode(12);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        root.right.right.right = new TreeNode(15);
        printZig(root);
    }
}
