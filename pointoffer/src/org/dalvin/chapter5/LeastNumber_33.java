package org.dalvin.chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qiudeyang on 23/12/16.
 */
public class LeastNumber_33 {
    public static String leastNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        String[] s_nums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s_nums[i]=String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1+o2;
                String s2 = o2+o1;
                return s1.compareTo(s2);
            }
        };
        Arrays.sort(s_nums,comp);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s_nums.length; i++) {
            sb.append(s_nums[i]);
        }
        String temp = sb.toString();
        int index = 0;
        while (temp.charAt(index)=='0'){
            index++;
        }
        return temp.substring(index);
    }

    public static void main(String[] args) {
        int[] nums = {03, 30, 321};
        System.out.println(leastNumber(nums));
    }
}
