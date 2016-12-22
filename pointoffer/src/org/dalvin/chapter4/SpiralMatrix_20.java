package org.dalvin.chapter4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiudeyang on 22/12/16.
 */
public class SpiralMatrix_20 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new LinkedList<Integer>();
        int row = matrix.length;
        if(matrix == null || row == 0){
            return list;
        }
        int column = matrix[0].length;
        int start = 0;
        while(row > 2*start && column > 2*start){
            list = printClockwisely(matrix,row,column,start,list);
            start++;
        }
        return list;
    }
    public static List<Integer> printClockwisely(int[][] matrix, int row, int column, int start, List<Integer> list){
        int endX = row - start - 1;
        int endY = column - start - 1;
        for(int i = start;i <= endY;i++){
            list.add(matrix[start][i]);
        }
        if(endX > start){
            for(int i = start+1;i <= endX;i++){
                list.add(matrix[i][endY]);
            }
        }
        if(endX > start && endY > start){
            for(int i = endY-1;i >= start;i--){
                list.add(matrix[endX][i]);
            }
        }
        if(endX > start + 1 && endY > start){
            for(int i = endX-1;i > start;i--){
                list.add(matrix[i][start]);
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[][] matrix = {{1}};
        System.out.println(spiralOrder(matrix));
    }
}
