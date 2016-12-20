package org.dalvin.chapter2;

import java.util.Stack;

/**
 * Created by qiudeyang on 19/12/16.
 */
public class PrintLinkedListReversely_5 {
    public static void printLinkedListReversely_5(ListNode node) {
        if (node == null) {
            return;
        }
        Stack<ListNode> stack = new Stack<ListNode>();
        while (node != null) {
            stack.push(node);
            node = node.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.peek().val);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        printLinkedListReversely_5(node);
    }
}
