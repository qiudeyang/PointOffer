package org.dalvin.chapter3;

/**
 * Created by qiudeyang on 20/12/16.
 */
//书上的解法有些问题。
public class Power_11 {
    boolean validInput = true;
    public double power(double x, int n) {
        if (isEqual(x,0.0) && n < 0){
            validInput = false;
            return 0.0;
        }
        if (n == 0){
            return 1.0;
        }
        if (n == Integer.MIN_VALUE){
            x = x * x;
            n = n >> 1;
        }
        if (n < 0){
            n = -n;
            x = 1/x;
        }
        if ((n & 1) == 1){
            return x*power(x*x,n>>1);
        }else{
            return power(x*x,n>>1);
        }
    }
    public boolean isEqual(double num1,double num2){
        if (Math.abs(num1-num2)<0.000001){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Power_11 power = new Power_11();
        System.out.println(power.power(0, -2));
    }
}
