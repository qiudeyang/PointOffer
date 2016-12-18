package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 18/12/16.
 */
public class SearchA2DMatrixII_3 {
    public static Boolean searchA2DMatrixII_3(int[][] array,int target){
        if (array == null){
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0){
            if (target == array[i][j]){
                return true;
            }else if (target < array[i][j]){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] array = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15},
        };
        int target = 5;
        System.out.println(searchA2DMatrixII_3(array,target));

    }
}
