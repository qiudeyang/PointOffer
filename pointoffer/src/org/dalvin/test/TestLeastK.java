package org.dalvin.test;

/**
 * Created by qiudeyang on 24/04/17.
 */

import java.util.*;

public class TestLeastK {

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return null;
        }
        String[] nums = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = numbers[i] + "";
        }
        Arrays.sort(nums, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String temp1 = o1 + o2;
                String temp2 = o2 + o1;
                return temp1.compareTo(temp2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] numbers = {3,32,321};
        System.out.println(new TestLeastK().PrintMinNumber(numbers));
    }
}
