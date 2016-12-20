package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 18/12/16.
 */
public class MergeTwoSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        while(i >= 0 && j >= 0){
            if(nums1[i] < nums2[j]){
                nums1[i+j+1] = nums2[j];
                j--;
            }else{
                nums1[i+j+1] = nums1[i];
                i--;
            }
        }
        if(j >= 0){
            for(int k = 0; k <= j;k++){
                nums1[k]=nums2[k];
            }
        }
        for (int k = 0; k < nums1.length; k++) {
            System.out.println(nums1[k]);
        }
    }
    public static void main(String[] args) {
        int[] nums1 = new int[10];
        nums1[0]=1;
        nums1[1]=3;
        nums1[2]=5;
        int[] nums2 = {0,2,4,6};
        merge(nums1,3,nums2,4);
    }
}
