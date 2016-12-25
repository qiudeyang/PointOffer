package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class ReverseSentence_42 {
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

    public static char[] reverseSentence(char[] data) {
        if (data == null || data.length == 0) {
            return data;
        }
        reverse(data,0,data.length-1);
        int start = 0;
        int end = 0;
        while (start<data.length){
            if (data[start]==' '){
                start++;
                end++;
            }else if(end == data.length || data[end]==' '){
                reverse(data,start,end-1);
                end++;
                start=end;
            }else {
                end++;
            }
        }
        return data;
    }

    public static void main(String[] args) {
        char data[] = "I am a student.".toCharArray();
        System.out.println(data.length);
        System.out.println(reverseSentence(data));
    }
}
