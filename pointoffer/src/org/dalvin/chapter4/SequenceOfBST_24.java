package org.dalvin.chapter4;

/**
 * Created by qiudeyang on 19/01/17.
 */
public class SequenceOfBST_24 {
    public static boolean sequenceOfBST(int[] array, int start, int end) {
        if (array == null || array.length == 0) {
            return false;
        }
        int i = start;
        int root = array[end];
        for (; i < end; i++) {
            if (array[i] > root){
                break;
            }
        }
        int j = i;
        for (; j < end; j++) {
            if (array[j] < root){
                return false;
            }
        }
        boolean left = true;
        if (i > start){
            left = sequenceOfBST(array,start,i-1);
        }
        boolean right = true;
        if (j < end ){
            right = sequenceOfBST(array,i,end);
        }
        return left && right;
    }

    public static void main(String[] args) {
        int[] array = {7,4,6,5};
        int length = array.length;
        System.out.println(sequenceOfBST(array, 0, length - 1));
    }
}
