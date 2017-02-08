package org.dalvin.chapter4;

import org.dalvin.chapter4.ComplexListNode;

/**
 * Created by qiudeyang on 08/02/17.
 */
public class ComplexListNodeCopy_26 {
    //分三步
    public static void cloneNodes(ComplexListNode node) {
        ComplexListNode temp = node;
        while (temp != null) {
            ComplexListNode cloned = new ComplexListNode();
            cloned.val = temp.val;
            cloned.next = temp.next;
            cloned.sibling = null;

            temp.next = cloned;

            temp = cloned.next;
        }
    }

    public static void connectSiblingNodes(ComplexListNode node) {
        ComplexListNode temp = node;
        while (temp != null) {
            ComplexListNode cloned = temp.next;
            if (temp.sibling != null) {
                cloned.sibling = temp.sibling.next;
            }
            temp = cloned.next;
        }
    }

    public static ComplexListNode reConnectNodes(ComplexListNode node) {
        ComplexListNode pNode = node;
        ComplexListNode pClonedHead = null;
        ComplexListNode pClonedNode = null;
        if (pNode != null) {
            pClonedHead = pNode.next;
            pClonedNode = pNode.next;
            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        while (pNode != null) {
            pClonedNode.next = pNode.next;
            pClonedNode = pClonedNode.next;

            pNode.next = pClonedNode.next;
            pNode = pNode.next;
        }
        return pClonedHead;
    }

    public static void main(String[] args) {
        ComplexListNode node = new ComplexListNode(1);
        node.next = new ComplexListNode(2);
        node.next.next = new ComplexListNode(3);
        node.next.next.next = new ComplexListNode(4);
        node.next.next.next.next = new ComplexListNode(5);
        node.sibling = new ComplexListNode(3);
        node.next.sibling = new ComplexListNode(5);
        node.next.next.next.sibling = new ComplexListNode(2);
        cloneNodes(node);
        connectSiblingNodes(node);
        System.out.println(reConnectNodes(node).val);
    }
}
