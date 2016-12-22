package org.dalvin.chapter4;

import java.util.Stack;

/**
 * Created by qiudeyang on 22/12/16.
 */
public class MinStack_21 {
    public static void pushStack(Stack<Integer> dataStack, Stack<Integer> assistStack, int x) {
        dataStack.push(x);
        if (assistStack.size() == 0 || x < assistStack.peek()) {
            assistStack.push(x);
        } else {
            assistStack.push(assistStack.peek());
        }
    }

    public static void pop(Stack<Integer> dataStack, Stack<Integer> assistStack) {
        if (dataStack.size() != 0 && assistStack.size() != 0) {
            dataStack.pop();
            assistStack.pop();
        }
    }

    public static Integer getMin(Stack<Integer> dataStack, Stack<Integer> assistStack) {
        if (dataStack.size() != 0 && assistStack.size() != 0) {
            return assistStack.peek();
        }
        return 0;
    }

    public static void main(String[] args) {
        Stack<Integer> dataStack = new Stack<Integer>();
        Stack<Integer> assistStack = new Stack<Integer>();

    }
}
