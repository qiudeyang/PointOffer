package org.dalvin.chapter8.linklist;

import org.dalvin.chapter2.ListNode;

/**
 * Created by qiudeyang on 27/12/16.
 */
public class EntryNodeOfLoop_56 {
    public static ListNode entryNodeOfLoop(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode pSlow = node;
        ListNode pFast = node;
        ListNode loopNode = null;
        while (pFast != null && pFast.next != null && pFast.next.next != null) {
            pSlow = pSlow.next;
            pFast = pFast.next.next;
            if (pFast == pSlow) {
                loopNode = pFast;
                break;
            }
        }
        if (loopNode == null) {
            return null;
        }
        int length = 1;
        ListNode temp = loopNode.next;
        while (temp != loopNode){
            temp = temp.next;
            length++;
        }
        ListNode pSlow1 = node;
        ListNode pFast1 = node;
        for (int i = 0; i < length; i++) {
            pFast1 = pFast1.next;
        }
        while (pFast1 != pSlow1){
            pFast1 = pFast1.next;
            pSlow1 = pSlow1.next;
        }
        return pFast1;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
//        node.next.next.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next.next = node.next.next;
        System.out.println(entryNodeOfLoop(node).val);
    }
}
