package org.dalvin.chapter8.linklist;

import org.dalvin.chapter2.ListNode;

/**
 * Created by qiudeyang on 27/12/16.
 */
public class RemoveDuplicateNode_57 {
    public static ListNode removeDuplicateNode(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pPreNode = null;
        ListNode pNode = node;
        while (pNode != null) {
            boolean delete = false;
            ListNode pNext = pNode.next;
            if (pNext != null && pNext.val == pNode.val) {
                delete = true;
            }
            if (!delete) {
                pPreNode = pNode;
                pNode = pNode.next;
            }else{
                int value = pNode.val;
                ListNode tobeDelete = pNode;
                while (tobeDelete != null && tobeDelete.val == value){
                    pNext = tobeDelete.next;
                    tobeDelete = null;
                    tobeDelete = pNext;
                }
                if (pPreNode == null){
                    node = pNext;
                }else{
                    pPreNode.next = pNext;
                }
                pNode = pNext;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);
        ListNode current = removeDuplicateNode(node);
        while (current != null) {
            System.out.print(current.val + "\t");
            current = current.next;
        }
    }
}
