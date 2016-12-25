package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class InFisrtStringDeleteAllCharactersAppearedInSecondString {
    public static String inFisrtStringDeleteAllCharactersAppearedInSecondString(String str1, String str2) {
        if (str1 == null || str1.length() == 0) {
            return null;
        }
        int[] nums = new int[256];
        for (int i = 0; i < str2.length(); i++) {
            nums[str2.charAt(i) - 0]++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if (nums[str1.charAt(i)- 0] == 0){
                sb.append(str1.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "We are students";
        String str2 = "aeiou";
        System.out.println(inFisrtStringDeleteAllCharactersAppearedInSecondString(str1, str2));
    }
}
