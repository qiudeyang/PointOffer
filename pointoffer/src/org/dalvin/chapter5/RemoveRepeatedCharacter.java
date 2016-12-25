package org.dalvin.chapter5;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class RemoveRepeatedCharacter {
    public static String removeRepeatedCharacter(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        boolean[] nums = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (nums[str.charAt(i) - 'a'] == false) {
                nums[str.charAt(i) - 'a'] = true;
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "google";
        System.out.println(removeRepeatedCharacter(str));
    }
}
