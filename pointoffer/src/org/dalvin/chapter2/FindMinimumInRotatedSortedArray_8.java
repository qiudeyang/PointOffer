package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 20/12/16.
 */
public class FindMinimumInRotatedSortedArray_8 {
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
//            下面这种情况需要考虑到。
            if (nums[index1] == nums[index2] && nums[indexMid] == nums[index1]) {
                return orderFindMin(nums, index1, index2);
            }
            if (nums[indexMid] >= nums[index1]) {
                index1 = indexMid;
            } else if (nums[indexMid] <= nums[index2]) {
                index2 = indexMid;
            }
        }
        return nums[indexMid];
    }

    public static int orderFindMin(int[] nums, int index1, int index2) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[index1];
        for (int i = index1 + 1; i <= index2; i++) {
            if (result > nums[i]) {
                result = nums[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,1};
        System.out.println(findMin(nums));
    }
}
