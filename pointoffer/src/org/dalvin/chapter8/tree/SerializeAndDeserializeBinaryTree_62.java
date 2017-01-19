package org.dalvin.chapter8.tree;

import org.dalvin.chapter2.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiudeyang on 18/01/17.
 */
public class SerializeAndDeserializeBinaryTree_62 {
    private static final String spliter = ",";
    private static final String NN = "X";

    public static String serializeBinaryTree(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    public static void buildString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NN).append(spliter);
        } else {
            sb.append(root.val).append(spliter);
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    public static TreeNode deserializeBinaryTree(String data) {
        Queue<String> queue = new LinkedList<String>();  //用队列实现
        queue.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(queue);
    }
    public static TreeNode buildTree(Queue<String> queue){
        String val = queue.poll();
        if (val.equals(NN)){
            return null;
        }else{
            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(queue);
            node.right = buildTree(queue);
            return node;
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
        System.out.println(serializeBinaryTree(root));
        System.out.println(deserializeBinaryTree(serializeBinaryTree(root)).left.val);
    }
}
