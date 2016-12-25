package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class GetNumberOfK_38 {
    public static int getNumberOfK(int[] nums, int k) {
        int number = 0;
        int length = nums.length;
        if (nums != null && length > 0){
            int first = getFistK(nums,k,length,0,length-1);
            int last = getLastK(nums,k,length,0,length-1);
            if (first != -1 && last != -1){
                number = last-first+1;
            }
        }
        return number;
    }
    public static int getFistK(int[] nums,int k,int length,int start,int end){
        if (start>end){
            return -1;
        }
        int middleIndex = (start+end)/2;
        int middle = nums[middleIndex];
        if (middle == k){
            if((middleIndex > 0 && nums[middleIndex-1] != k) || middleIndex == 0){
                return middleIndex;
            }else{
                end = middleIndex - 1;
            }
        }else if(middle >  k){
            end = middleIndex - 1;
        }else{
            start = middleIndex + 1;
        }
        return getFistK(nums,length,k,start,end);
    }
    public static int getLastK(int[] nums,int k,int length,int start,int end){
        if (start>end){
            return -1;
        }
        int middleIndex = (start+end)/2;
        int middle = nums[middleIndex];
        if (middle == k){
            if((middleIndex < length - 1 && nums[middleIndex+1] != k) || middleIndex == length-1){
                return middleIndex;
            }else{
                start = middleIndex + 1;
            }
        }else if(middle >  k){
            end = middleIndex - 1;
        }else{
            start = middleIndex + 1;
        }
        return getLastK(nums,k,length,start,end);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 3, 4};
        System.out.println(getNumberOfK(nums, 3));
    }
}
