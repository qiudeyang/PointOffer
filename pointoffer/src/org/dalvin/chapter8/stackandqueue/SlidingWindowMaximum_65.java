package org.dalvin.chapter8.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by qiudeyang on 18/01/17.
 */
public class SlidingWindowMaximum_65 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int length = nums.length;
        int[] result = new int[length - k + 1];  //滑动窗口的最大值
        Deque<Integer> queue = new ArrayDeque<Integer>();  //双端数列存原数组的下标值
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //超过了滑动窗口的范围，删除前面的值
            while (!queue.isEmpty() && queue.peek() < i - k + 1) {
                queue.poll();
            }
            //值小于最大值，删除后面的值
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result = maxSlidingWindow(array, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }
}
