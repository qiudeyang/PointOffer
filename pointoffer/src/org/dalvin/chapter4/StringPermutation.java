package org.dalvin.chapter4;

/**
 * Created by qiudeyang on 08/02/17.
 */
//字符串的全组合.基于位图。
//假设原有元素n个，最终的组合结果有2^n - 1. 可以使用2^n - 1个位，1表示取该元素，0表示不取。 所以a表示001,取ab是011。
//        001,010,011,100,101,110,111。对应输出组合结果为：a,b,ab,c,ac,bc,abc。
//        因此可以循环 1~2^n-1(字符串长度)，然后输出对应代表的组合即可。
public class StringPermutation {
    public static void stringPermutation(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        char[] array = str.toCharArray();
        int length = array.length;
        int n = 1 << length;
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if ((i & (1 << j)) != 0){
                    sb.append(array[j]);
                }
            }
            System.out.println(sb+" ");
        }
    }

    public static void main(String[] args) {
        stringPermutation("abc");
    }
}
