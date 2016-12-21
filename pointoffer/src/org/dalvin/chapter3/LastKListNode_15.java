package org.dalvin.chapter3;

import org.dalvin.chapter2.ListNode;

/**
 * Created by qiudeyang on 21/12/16.
 */
public class LastKListNode_15 {
    public static ListNode printLastKListNode(ListNode node,int k){
        if (node == null || k <= 0){
            return null;
        }
        ListNode temp = node;
        for (int i = 0; i < k-1; i++) {
            if (temp == null){
                return null;
            }
            temp = temp.next;
        }
        while (temp.next != null){
            temp = temp.next;
            node = node.next;
        }
        return node;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        System.out.println(printLastKListNode(node,1));
    }
}
