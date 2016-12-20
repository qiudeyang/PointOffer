package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 19/12/16.
 */
public class BinarySearch {
    public static int binarySearch(int[] nums,int target){
        if (nums == null || nums.length <= 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high){
            int mid = (low+high)/2;
            if (target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] nums = null;
        System.out.println(binarySearch(nums,3));
    }
}
