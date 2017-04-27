package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 07/02/17.
 */
//不能使用乘除、for,while,if,else,switch,case等关键字计算1+2+...+n的值
public class Accumulate_46 {
    //用&&或||代替递归条件。
    public static int accumulate(int n){
        if (n < 1){
            return 0;
        }
        int result = 0;
//        boolean b = (n > 0) && (result = n + accumulate(n-1)) > 0;
        boolean b = (n == 0) || (result = n + accumulate(n-1)) > 0;
        return result;
    }
    //感觉下面这方法更巧妙。
    public static int accumulate1(int n){
        int result = (int)(Math.pow(n,2)+n);
        return result>>1;
    }
    public static void main(String[] args) {
        System.out.println(accumulate(7));
        System.out.println(accumulate1(7));
    }
}
