package org.dalvin.chapter3;

import org.dalvin.chapter2.ListNode;

/**
 * Created by qiudeyang on 21/12/16.
 */
public class MergeTwoSortedLists_17 {
    //下面是递归解法
    public static ListNode mergeTwoSortedLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val < node2.val){
            node1.next = mergeTwoSortedLists(node1.next,node2);
            return node1;
        }else{
            node2.next = mergeTwoSortedLists(node1,node2.next);
            return node2;
        }
    }
    //下面是非递归解法
    public static ListNode mergeTwoSortedLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode l3 = new ListNode(0);
        ListNode l4 = l3;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                l3.next = l1;
                l1 = l1.next;
            }else{
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        while(l1 != null){
            l3.next = l1;
            l1 = l1.next;
            l3 = l3.next;
        }
        while(l2 != null){
            l3.next = l2;
            l2 = l2.next;
            l3 = l3.next;
        }
        return l4.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(4);
        ListNode node2 = new ListNode(0);
        node2.next = new ListNode(3);
//        node2.next.next = new ListNode(6);
        ListNode current = mergeTwoSortedLists1(node1, node2);
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}
