package org.dalvin.chapter8;

/**
 * Created by qiudeyang on 26/12/16.
 */
public class ProductOfArrayExceptSelf_52 {
    //这个方法巧妙在于把乘积的结果分为两部分，比如i，0-i-1,i+1,num.length
    public static int[] productOfArrayExceptSelf(int[] nums){
        if (nums == null || nums.length == 0){
            return nums;
        }
        int[] result = new int[nums.length];
        result[0]=1;
        for (int i = 1; i < nums.length ; i++) {
            result[i] = result[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0 ; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {0,2,3,4};
        int[] result = productOfArrayExceptSelf(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+"\t");
        }
    }
}
