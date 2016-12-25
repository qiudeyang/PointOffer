package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class FirstNotRepeatingChar_35 {
    public static char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return '0';
        }
        int[] nums = new int[256];
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i)-'0']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i)-'0']==1){
                return str.charAt(i);
            }
        }
        return '0';
    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        System.out.println(firstNotRepeatingChar(str));
    }
}
