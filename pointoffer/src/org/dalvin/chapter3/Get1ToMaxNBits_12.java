package org.dalvin.chapter3;

/**
 * Created by qiudeyang on 20/12/16.
 */
public class Get1ToMaxNBits_12 {
    public static void get1ToMaxNBits_12(int n){
        if (n <= 0){
            return;
        }
        char[] number = new char[n];
        for (int i = 0; i < 10; i++) {
            number[0]=(char)('0'+i);
            print1ToMaxOfNDigitsRecursively(number,n,0);
        }
    }
    public static void print1ToMaxOfNDigitsRecursively(char[] number,int length,int index){
        if (index == length-1){
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index+1]=(char)(i+'0');
            print1ToMaxOfNDigitsRecursively(number,length,index+1);
        }
    }
    public static void printNumber(char[] number){
        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean allZero = true;
        for (int i = 0; i < number.length; i++) {
            if (number[i]!='0'){
                index = i;
                allZero = false;
                break;
            }
        }
        if (allZero){
            return;
        }
        for (int i = index; i < number.length; i++) {
            sb.append(number[i]);
        }
        System.out.println(sb.toString());
    }
    public static void main(String[] args) {
        int n = 3;
        get1ToMaxNBits_12(3);
    }
}
