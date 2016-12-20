package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 20/12/16.
 */
public class NumberOf1Bits_10 {
    public static int numberOf1Bits(int n){
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(numberOf1Bits(10));
    }
}
