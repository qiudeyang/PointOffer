package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 23/12/16.
 */
public class NumberOfDigitOne_32 {
    //解法：https://discuss.leetcode.com/topic/27565/java-python-one-pass-solution-easy-to-understand
    public static int numberOfDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int q = n;
        int x = 1;
        int result = 0;
        while (q > 0) {
            int digit = q % 10;
            q /= 10;
            result += q * x;
            if (digit == 1) {
                result += n % x + 1;
            }
            if (digit > 1) {
                result += x;
            }
            x *= 10;
        }
        return result;

    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numberOfDigitOne(n));
    }
}
