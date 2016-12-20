package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 19/12/16.
 */
public class SortedAges {
    public static void sortAges(int[] ages) {
        int length = ages.length;
        if (ages == null || length <= 0) {
            return;
        }
        int maxAges = 99;
        int[] countArray = new int[maxAges+1];
        for (int i = 0; i < length; i++) {
            int age = ages[i];
            if (age < 0 || age > maxAges){
                return;
            }
            countArray[age]++;
        }
        int index = 0;
        for (int i = 0; i <= maxAges; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                ages[index]=i;
                index++;
            }
        }
        for (int i = 0; i < length; i++) {
            System.out.println(ages[i]);
        }
    }

    public static void main(String[] args) {
        int[] ages = {4, 64, 0,56,88, 72, 56, 88};
        sortAges(ages);
    }
}
