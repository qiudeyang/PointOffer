package org.dalvin.chapter6;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class SingleNumber_40 {
    public static List getSingleNumber(int[] nums) {
        List<Integer> list = new LinkedList<Integer>();
        if (nums == null || nums.length < 2) {
            return list;
        }
        int xorResult = 0;
        for (int i = 0; i < nums.length; i++) {
            xorResult ^= nums[i];
        }
        int bit1Position = findFirst1Bit(xorResult);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isBit1(nums[i],bit1Position)){
                num1 ^= nums[i];
            }else{
                num2 ^= nums[i];
            }
        }
        list.add(num1);
        list.add(num2);
        return list;
    }
    public static int findFirst1Bit(int xorResult){
        int result = 0;
        while ((xorResult & 1) == 0){
            result++;
            xorResult = xorResult >> 1;
        }
        return result;
    }
    public static boolean isBit1(int num,int bitPosition){
        num = num >> bitPosition;
        if ((num & 1) == 1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 3, 6, 3, 2, 5, 5};
        System.out.println(getSingleNumber(nums));
    }
}
