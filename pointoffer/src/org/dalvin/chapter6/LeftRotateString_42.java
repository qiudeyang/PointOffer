package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 25/12/16.
 */
public class LeftRotateString_42 {
    public static void reverse(char[] data, int start, int end) {
        if (data == null || data.length == 0 || start < 0 || end > data.length - 1 || start > end) {
            return;
        }
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }
    public static void leftRotateString(char[] data,int n){
        if (data == null || data.length == 0 || n < 0){
            return;
        }
        n = n % data.length;
        reverse(data,0,n-1);
        reverse(data,n,data.length-1);
        reverse(data,0,data.length-1);
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        char[] data = s.toCharArray();
        leftRotateString(data,2);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i]);
        }
    }
}
