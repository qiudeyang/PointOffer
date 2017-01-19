package org.dalvin.chapter4;

import org.dalvin.chapter2.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiudeyang on 19/01/17.
 */
public class FindPathInBinaryTree_25 {
    static List<List<Integer>> result = new LinkedList<List<Integer>>();
    public static List<List<Integer>> findPathInBinaryTree(TreeNode root,int target){
        helper(new LinkedList<Integer>(),root,target);
        return result;
    }
    public static void helper(List<Integer> list,TreeNode root,int target){
        if (root == null){
            return;
        }
        target -= root.val;
        list.add(root.val);
        if (root.left == null && root.right == null){
            if (target == 0){
                result.add(list);
            }
            return;
        }
        helper(new LinkedList<>(list),root.left,target);
        helper(new LinkedList<>(list),root.right,target);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        System.out.println(findPathInBinaryTree(root,22));
    }
}
