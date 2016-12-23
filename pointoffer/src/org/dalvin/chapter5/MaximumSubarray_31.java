package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 23/12/16.
 */
public class MaximumSubarray_31 {
    public static int maximumSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxElement = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxElement < nums[i]) {
                maxElement = nums[i];
            }
        }
        if (maxElement < 0) {
            return maxElement;
        }
        int curSum = 0;
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += nums[i];
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,-3,-1};
        System.out.println(maximumSubarray(nums));
    }
}
