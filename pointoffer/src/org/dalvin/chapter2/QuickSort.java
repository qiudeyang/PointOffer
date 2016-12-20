package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 19/12/16.
 */
public class QuickSort {
    public static void quickSort(int[] nums){
        qSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
    public static void qSort(int[] nums,int low,int high){
        if (low < high){
            int pivot = partition(nums,low,high);
            qSort(nums,low,pivot-1);
            qSort(nums,pivot+1,high);
        }
    }
    public static int partition(int[] nums,int low,int high){
        int pivot = nums[low];
        while (low < high){
            while (low < high && nums[high] > pivot){
                high--;
            }
            nums[low]=nums[high];
            while (low < high && nums[low] <= pivot){
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;
        return low;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,6,1,7,4,8,5};
        quickSort(nums);
    }
}
