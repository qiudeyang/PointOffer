package org.dalvin.chapter6;

import java.util.Arrays;

/**
 * Created by qiudeyang on 05/02/17.
 */
public class IsContinuous_44 {
    public static boolean isContinuous(int[] number) {
        if (number == null || number.length < 1) {
            return false;
        }
        int length = number.length;
        int countOfZero = 0;
        int countOfGap = 0;
        Arrays.sort(number);
        //统计数组中0的个数
        for (int i = 0; i < length && number[i] == 0; i++) {
            countOfZero++;
        }
        int small = countOfZero;
        int big = small + 1;
        //统计数组中的间隔数目
        while (big < length){
            //两个数相等，有对子，则不可能是顺子。
            if (number[big]==number[small]){
                return false;
            }
            countOfGap += number[big]-number[small]-1;
            small = big;
            big++;
        }
        return countOfGap > countOfZero ? false:true;
    }

    public static void main(String[] args) {
        int[] number = {4, 1, 0, 0, 6};
        System.out.println(isContinuous(number));
    }
}
