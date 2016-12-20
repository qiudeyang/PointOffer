package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 20/12/16.
 */
public class Fibonacci {
    public static long fibonacci(int n){
        int[] result = {0,1};
        if (n < 2){
            return result[n];
        }
        int fibnacciOld = 0;
        int fibancciNew = 1;
        int fibN = 0;
        for (int i = 2; i <= n ; i++) {
            fibN = fibnacciOld + fibancciNew;
            fibnacciOld = fibancciNew;
            fibancciNew = fibN;
        }
        return fibN;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }
}
