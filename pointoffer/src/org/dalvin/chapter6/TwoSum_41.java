package org.dalvin.chapter6;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class TwoSum_41 {
    public static List twoSum(int[] nums,int target){
        List<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length < 2){
            return list;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end){
            if (nums[start]+nums[end]==target){
                list.add(nums[start]);
                list.add(nums[end]);
                return list;
            }else if (nums[start]+nums[end]>target){
                end--;
            }else{
                start++;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,7,11,15};
        System.out.println(twoSum(nums,15));
    }
}
