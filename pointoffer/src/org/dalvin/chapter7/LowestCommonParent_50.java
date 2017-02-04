package org.dalvin.chapter7;

import org.dalvin.chapter2.TreeNode;

import java.util.Stack;

/**
 * Created by qiudeyang on 04/02/17.
 */
public class LowestCommonParent_50 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        getPath(root, p, stackP);
        getPath(root, q, stackQ);
        TreeNode result = null;
        while (!stackP.isEmpty() && !stackQ.isEmpty() && stackP.peek() == stackQ.peek()) {
            result = stackP.peek();
            stackP.pop();
            stackQ.pop();
        }
        return result;
    }

    //    这个代码在实现过程中，是当找到给定节点的时候才将路径依次压入stack中的，
//            * 也就是说，两个stack的栈顶都是存放着root节点。
//            * 因此，此时就应该找两条路径分离开之前的最后一个节点，
//            * 此节点就是所求的最低公共祖先。
    public static boolean getPath(TreeNode root, TreeNode p, Stack<TreeNode> stackP) {
        if (root == null) {
            return false;
        }
        if (root == p) {
            stackP.push(root);
            return true;
        } else {
            if (getPath(root.left, p, stackP) || getPath(root.right, p, stackP)) {
                stackP.push(root);
                return true;
            } else {
                return false;
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
        System.out.println(lowestCommonAncestor(root, root.left.right, root.right.left).val);
    }
}
