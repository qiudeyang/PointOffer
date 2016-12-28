package org.dalvin.chapter8.array;

/**
 * Created by qiudeyang on 26/12/16.
 */
public class RepeatedNumberInArray_51 {
    static boolean isExistRepeatedNumber = false;
    public static int repeatedNumber(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    isExistRepeatedNumber = true;
                    return nums[i];
                }
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6, 3, 1, 0, 2, 5, 4};
        System.out.println(repeatedNumber(nums));
        System.out.println(isExistRepeatedNumber);
    }
}
