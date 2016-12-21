package org.dalvin.chapter3;

import org.dalvin.chapter2.ListNode;

import java.util.Stack;

/**
 * Created by qiudeyang on 21/12/16.
 */

public class ReverseLinkedList_16 {
    //遍历解法
    public static ListNode reverseLinkedList(ListNode node) {
        ListNode reverseHead = null;
        ListNode pNode = node;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode pNext = pNode.next;
            if (pNext == null) {
                reverseHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = pNext;
        }
        return reverseHead;
    }
    //递归解法
    public static ListNode reverseLinkedList1(ListNode node) {
        return helper(node,null);
    }
    public static ListNode helper(ListNode node,ListNode newHead){
        if (node == null){
            return newHead;
        }
        ListNode next = node.next;
        node.next = newHead;
        return helper(next,node);
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        ListNode current = reverseLinkedList1(node);
        while (current != null) {
            System.out.print(current.val+"\t");
            current = current.next;
        }
    }
}
