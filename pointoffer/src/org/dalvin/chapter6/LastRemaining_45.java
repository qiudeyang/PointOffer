package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 05/02/17.
 */
public class LastRemaining_45 {
    //分析每次被删除的数字的规律并直接计算出圆圈中最后剩下的数字，找规律。
    public static int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n ; i++) {
            last = (last+m)%i;
        }
        return last;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(4000,997));
    }
}
