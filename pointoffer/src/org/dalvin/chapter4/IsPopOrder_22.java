package org.dalvin.chapter4;

import java.util.Stack;

/**
 * Created by qiudeyang on 19/01/17.
 */
//判断一个序列是不是栈的弹出序列的规律：如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。
// 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。
// 如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。
public class IsPopOrder_22 {
    public static boolean isPopOrder(int[] push, int[] pop) {
        if (push == null || pop == null || push.length == 0 || pop.length == 0 || push.length != pop.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int pushIndex = 0;
        int popIndex = 0;
        while (popIndex < pop.length) {
            while (pushIndex < push.length && (stack.isEmpty() || stack.peek() != pop[popIndex])) {
                stack.push(push[pushIndex]);
                pushIndex++;
            }
            if (stack.peek() == pop[popIndex]) {
                stack.pop();   //这一步千万别忘了，出栈。
                popIndex++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] push = {1, 2, 3, 4, 5};
        int[] pop = {4, 3,5,1,2};
        System.out.println(isPopOrder(push, pop));
    }
}
