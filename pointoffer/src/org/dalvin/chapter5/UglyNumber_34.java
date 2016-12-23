package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 23/12/16.
 */
public class UglyNumber_34 {
    public static int uglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] nums = new int[n];
        nums[0] = 1;
        int index = 1;
        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;
        int pMultiply2 = nums[temp1];
        int pMultiply3 = nums[temp2];
        int pMultiply5 = nums[temp3];
        while (index < n) {
            int min = Math.min(Math.min(pMultiply2 * 2, pMultiply3 * 3), pMultiply5 * 5);
            nums[index] = min;
            while (pMultiply2 * 2 <= nums[index]) {
                pMultiply2 = nums[temp1++];
            }
            while (pMultiply3 * 3 <= nums[index]) {
                pMultiply3 = nums[temp2++];
            }
            while (pMultiply5 * 5 <= nums[index]) {
                pMultiply5 = nums[temp3++];
            }
            index++;
        }
        return nums[n - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(uglyNumber(1500));
    }
}
