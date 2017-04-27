package org.dalvin.test;

/**
 * Created by qiudeyang on 24/04/17.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class TestStringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str == null || str.length() < 1){
            return list;
        }
        char[] array = str.toCharArray();
        helper(array,list,0,array.length-1);
        return list;
    }
    public void helper(char[] array,ArrayList<String> list,int start,int end){
        if(start > end){
            return;
        }
        if(start==end){
            list.add(new String(array));
            return;
        }
        for(int i = start;i <= end;i++){
            swap(array,start,i);
            helper(array,list,start+1,end);
            swap(array,i,start);
        }
    }

    public void swap(char[] array,int i,int j){
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new TestStringPermutation().Permutation("aa"));
    }
}
