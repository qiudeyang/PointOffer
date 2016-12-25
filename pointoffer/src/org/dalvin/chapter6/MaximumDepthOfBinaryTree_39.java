package org.dalvin.chapter6;

import org.dalvin.chapter2.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class MaximumDepthOfBinaryTree_39 {
    public static int maximumDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        return 1+Math.max(maximumDepth(root.left),maximumDepth(root.right));
    }
    public static int maximumDepth1(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (temp.left != null){
                    queue.offer(temp.left);
                }
                if (temp.right != null){
                    queue.offer(temp.right);
                }
            }
            if (queue.size() > 0){
                depth++;
            }else {
                break;
            }
        }
        return depth;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.right.left = new TreeNode(7);
        System.out.println(maximumDepth1(root));
    }
}
