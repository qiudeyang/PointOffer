package org.dalvin.chapter2;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by qiudeyang on 19/12/16.
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_6 {
    public static TreeNode buildTree(int[] preorder,int[] midorder){
        if (preorder == null || preorder.length == 0 ||midorder == null || midorder.length == 0 ){
            return null;
        }
        return helper(0,0,midorder.length-1,preorder,midorder);
    }
    public static TreeNode helper(int preStart,int inStart,int inEnd,int[] preorder,int[] midorder){
        if(preStart > preorder.length - 1 || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd ; i++) {
            if (midorder[i]==root.val){
                inIndex = i;
            }
        }
        root.left = helper(preStart+1,inStart,inIndex-1,preorder,midorder);
        root.right = helper(preStart+1+inIndex-inStart,inIndex+1,inEnd,preorder,midorder);
        return root;
    }
    public static void broadthFirstTraversal(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + "  ");
            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }
    }

    public static void main(String[] args) {
        int[] preorder = {1,2,4,7,3,5,6,8};
        int[] midorder = {4,7,2,1,5,3,8,6};
        TreeNode root = buildTree(preorder,midorder);
        broadthFirstTraversal(root);
    }
}
