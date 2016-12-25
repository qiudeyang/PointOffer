package org.dalvin.chapter5;

import org.dalvin.chapter2.ListNode;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class IntersectionOfTwoLinkedLists_37 {
    public static ListNode intersectionOfTwoLinkedLists(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return null;
        }
        int node1Length = length(node1);
        int node2Length = length(node2);
        int lengthDiff = node1Length - node2Length;
        ListNode pLongNode = node1;
        ListNode pShortNode = node2;
        if (node2Length > node1Length){
            pLongNode = node2;
            pShortNode = node1;
            lengthDiff = node2Length - node1Length;
        }
        for (int i = 0; i < lengthDiff; i++) {
            pLongNode = pLongNode.next;
        }
        while ((pLongNode != null) && (pShortNode != null) && (pLongNode.val != pShortNode.val)){
            pLongNode = pLongNode.next;
            pShortNode = pShortNode.next;
        }
        ListNode result = pLongNode;
        return result;
    }

    public static int length(ListNode node) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        ListNode temp = node;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(6);
        node1.next.next.next.next = new ListNode(7);
        ListNode node2 = new ListNode(4);
        node2.next = new ListNode(5);
        node2.next.next = new ListNode(6);
        node2.next.next.next = new ListNode(7);
        System.out.println(intersectionOfTwoLinkedLists(node1, node2).val);
    }
}
