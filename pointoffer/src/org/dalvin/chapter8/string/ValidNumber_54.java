package org.dalvin.chapter8.string;

/**
 * Created by qiudeyang on 27/12/16.
 */
public class ValidNumber_54 {
    public static boolean validNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int index = 0;
        int length = str.length();
        System.out.println(length);
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        if (index >= length) {
            return false;
        }
        boolean result = true;
        index = numeric(str, index, length);
        if (index < length) {
            //小数
            if (str.charAt(index) == '.') {
                index++;
                index = numeric(str, index, length);
                if (index < length && str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                    result = isExponential(str, index, length);
                }
                //整数
            } else if (str.charAt(index) == 'e' || str.charAt(index) == 'E') {
                result = isExponential(str, index, length);
            } else {
                result = false;
            }
        }
        return result && (index >= length);
    }

    public static int numeric(String str, int index, int length) {
        while (str.charAt(index) >= '0' && str.charAt(index) <= '9' && index < length) {
            index++;
        }
        return index;
    }

    public static boolean isExponential(String str, int index, int length) {
        if (str.charAt(index) != 'e' && str.charAt(index) != 'E') {
            return false;
        }
        index++;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            index++;
        }
        if (index >= length) {
            return false;
        }
        index = numeric(str, index, length);
        return index >= length;
    }

    public static void main(String[] args) {
        String str1 = "-1E-16";
        String str2 = "1.2.3";
        System.out.println(validNumber(str1));
//        System.out.println(validNumber(str2));
    }
}
