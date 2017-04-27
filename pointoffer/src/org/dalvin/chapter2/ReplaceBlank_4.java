package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 18/12/16.
 */
public class ReplaceBlank_4 {
    public static String replaceBlank(String str){
        System.out.println(str.length());
        if(str == null || str.length() <= 0){
            return null;
        }
        char[] array = str.toCharArray();
        int indexOfOriginal = array.length - 1;
        int blankNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==' '){
                blankNumber++;
            }
        }
        if (blankNumber == 0){
            return str;
        }
        int indexOfNew = indexOfOriginal + blankNumber * 2;
        char[] result = new char[indexOfNew+1];
        while (indexOfOriginal >= 0 && indexOfNew > indexOfOriginal){
            if (array[indexOfOriginal]==' '){  //char类型可以直接跟int类型进行比较.char类型的空格换成int是32,array[indexOfOriginal]==32;
                result[indexOfNew--]='0';  //单引号
                result[indexOfNew--]='2';
                result[indexOfNew--]='%';
            }else{
                result[indexOfNew--]=array[indexOfOriginal];
            }
            indexOfOriginal--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

    public static String replaceBlank1(String str){
        if (str == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
             if (str.charAt(i)==' '){
                 sb.append("%20");
             }else{
                 sb.append(str.charAt(i));
             }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "We are happy";
        System.out.println(replaceBlank(str));
        System.out.println(replaceBlank1(str));
    }
}
