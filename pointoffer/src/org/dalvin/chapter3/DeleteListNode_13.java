package org.dalvin.chapter3;

/**
 * Created by qiudeyang on 20/12/16.
 */

import org.dalvin.chapter2.ListNode;

import java.util.HashMap;

public class DeleteListNode_13 {
    public static ListNode removeListNode(ListNode node, ListNode toDeleteNode) {
        if (node == null) {
            return null;
        }
        if (node.val == toDeleteNode.val){
            return null;
        }
        ListNode temp = node;
        boolean isExist = false;
        while (temp != null){
            if (temp.val == toDeleteNode.val){
                isExist = true;
                break;
            }
            temp = temp.next;
        }
        if (!isExist){
            return null;
        }
        if (temp.next != null){
            temp.val = temp.next.val;
            temp.next = temp.next.next;
            return node;
        }else{
            ListNode temp1 = node;
            while (temp1.next.val != toDeleteNode.val){
                temp1 = temp1.next;
            }
            temp1.next = null;
            return node;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        ListNode toDeleteNode = new ListNode(3);
        ListNode result = removeListNode(node, toDeleteNode);;
        while (result != null){
            System.out.print(result.val+"\t");
            result = result.next;
        }
    }
}
