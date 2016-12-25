package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class InversePairs_36 {
    //归并排序，时间复杂度为O(n*logn)
    public static int inversePairs(int[] data) {
        if (data == null || data.length == 0) {
            return 0;
        }
        int[] copy = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }
        return invesePairsCore(data, copy, 0, data.length - 1);
    }

    public static int invesePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }
        int length = (end - start) / 2;
        int left = invesePairsCore(copy, data, start, start + length);
        int right = invesePairsCore(copy, data, start + length + 1, end);
        int count = 0;
        int indexCopy = end;
        int i = start+length;
        int j = end;
        while (i>= start && j >= start+length+1){
            if (data[i]>data[j]){
                copy[indexCopy--]=data[i--];
                count += j-start-length;
            }else{
                copy[indexCopy--]=data[j--];
            }
        }
        for (; i >= start;i-- ) {
            copy[indexCopy--]=data[i];
        }
        for (; j >= start+length+1;j-- ) {
            copy[indexCopy--]=data[j];
        }
        return left+right+count;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        System.out.println(inversePairs(nums));
    }
}
