package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 22/12/16.
 */
public class MajorityElement_29 {
    boolean validInput = true;
    boolean isMoreThanHalf = true;
    public  int majorityElement(int[] nums){
        if (nums == null || nums.length == 0){
            validInput = false;
            return 0;
        }
        int result = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0){
                result = nums[i];
                times++;
            }else{
                if (nums[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }
        int length = nums.length;
        if (!hasMoreThanHalf(nums,length,result)){
            result = 0;
        }
        return result;
    }
    public  boolean hasMoreThanHalf(int[] nums, int length,int result){
        int times = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==result){
                times++;
            }
        }
        if (times*2 <= length){
            validInput = false;
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        MajorityElement_29 me = new MajorityElement_29();
        System.out.println(me.majorityElement(nums));
        System.out.println(me.validInput);
        System.out.println(me.isMoreThanHalf);
    }
}
