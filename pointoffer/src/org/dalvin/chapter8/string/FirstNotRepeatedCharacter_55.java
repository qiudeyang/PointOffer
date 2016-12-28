package org.dalvin.chapter8.string;

/**
 * Created by qiudeyang on 27/12/16.
 */
public class FirstNotRepeatedCharacter_55 {
    public static char firstNotRepeatedCharacter(String str1) {
        if (str1 == null || str1.length() == 0) {
            return 0;
        }
        int[] array = new int[128];
        for (int i = 0; i < str1.length(); i++) {
            array[str1.charAt(i) - 0]++;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (array[str1.charAt(i) - 0] == 1) {
                return str1.charAt(i);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str1 = "go";
        String str2 = "google";
        System.out.println(firstNotRepeatedCharacter(str1));
        System.out.println(firstNotRepeatedCharacter(str2));
    }
}
