package org.dalvin.chapter5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qiudeyang on 05/03/17.
 */
public class LargestNumber {
    public static String largestNumber(int[] array){
        if (array == null || array.length < 1){
            return null;
        }
        String[] str = new String[array.length];
        for (int i = 0; i < str.length; i++) {
            str[i]=array[i]+"";
        }
        Comparator<String> cmp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String temp1 = o1+o2;
                String temp2 = o2+o1;
                return temp2.compareTo(temp1);
            }
        };
        Arrays.sort(str,cmp);
        if (str[0].charAt(0)=='0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        int[] array = {3,30,34,5,9};
        System.out.println(largestNumber(array));
    }
}
