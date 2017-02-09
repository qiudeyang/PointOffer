package org.dalvin.chapter4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiudeyang on 07/02/17.
 */
//字符串的全排列，n个数的全排列，一共有n！种情况.
public class StringPermutation_28 {
    public static void stringPermutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] array = str.toCharArray();
        permutation(array, 0, array.length - 1);
    }

    public static void permutation(char[] array, int low, int high) {
        if (low == high) {
            System.out.println(array);
        } else {
            for (int i = low; i <= high ; i++) {
                swap(array,low,i);
                permutation(array,low+1,high);
                swap(array,i,low);
            }
        }
    }

    public static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static void main(String[] args) {
        stringPermutation("abcd");
    }
}
