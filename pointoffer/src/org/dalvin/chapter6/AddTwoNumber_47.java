package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 07/02/17.
 */
//不能使用加减乘除来实现计算两个数的和
public class AddTwoNumber_47 {
    public static int addTwoNumber(int num1,int num2){
        int sum;
        int carry;
        while (num2 != 0){
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }
    public static void main(String[] args) {
        System.out.println(addTwoNumber(5,17));
    }
}
