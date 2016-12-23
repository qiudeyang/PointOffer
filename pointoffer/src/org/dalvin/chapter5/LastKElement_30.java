package org.dalvin.chapter5;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by qiudeyang on 23/12/16.
 */
public class LastKElement_30 {
    //以下方式是使用分区，缺点是会修改输入的数组，时间复杂度是O（n）
    static boolean validInput = true;

    public static int[] lastKElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums1.length < nums2.length) {
            validInput = false;
            return nums2;
        }
        int start = 0;
        int end = nums1.length - 1;
        int index = Partitions(nums1, start, end);
        while (index != nums2.length - 1) {
            if (index > nums2.length - 1) {
                index = Partitions(nums1, start, index - 1);
            } else {
                index = Partitions(nums1, index + 1, end);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i] = nums1[i];
        }
        return nums2;
    }

    public static int Partitions(int[] nums1, int start, int end) {
        if (nums1 == null || nums1.length == 0 || start > end) {
            return -1;
        }
        int pivot = nums1[start];
        while (start < end) {
            while (start < end && nums1[end] >= pivot) {
                end--;
            }
            nums1[start] = nums1[end];
            while (start < end && nums1[start] < pivot) {
                start++;
            }
            nums1[end] = nums1[start];
        }
        nums1[start] = pivot;
        return start;
    }

    //用红黑树或堆，时间复杂度是O（n*logk），适合处理海量数据，且不改变原数据。
    public static int[] lastKElement1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums1.length < nums2.length) {
            validInput = false;
            return nums2;
        }
        //注意这里要重写Comparator方法，因为默认从1到大排序。
        Queue<Integer> queue = new PriorityQueue<Integer>(nums2.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(nums1[i]);
            if (queue.size()>nums2.length){
                queue.poll();
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2[i]=queue.poll();
        }
        return nums2;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        int[] nums2 = new int[k];
        nums2 = lastKElement1(nums1, nums2);
        for (int i = 0; i < nums2.length; i++) {
            System.out.print(nums2[i] + "\t");
        }
    }
}
