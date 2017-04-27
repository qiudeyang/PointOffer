package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 12/04/17.
 */
public class ReverseListNode {
    public static ListNode reverseListNodeNormal(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode current = node;
        ListNode nextNode;
        ListNode reverseHead = null;
        while (current != null) {
            nextNode = current.next;
            current.next = reverseHead;
            reverseHead = current;
            current = nextNode;
        }
        return reverseHead;
    }

    public static ListNode reverseListNodeRecurily(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode nextNode = node.next;
        node.next = null;
        ListNode reverseHead = reverseListNodeRecurily(nextNode);
        nextNode.next = node;
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
//        ListNode result1 = reverseListNodeNormal(node);
//        while (result1 != null) {
//            System.out.print(result1.val + "\t");
//            result1 = result1.next;
//        }
        System.out.println();
        ListNode result2 = reverseListNodeRecurily(node);
        while (result2 != null) {
            System.out.print(result2.val + "\t");
            result2 = result2.next;
        }

    }
}
