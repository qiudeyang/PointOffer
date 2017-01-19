package org.dalvin.chapter8.backtrack;

/**
 * Created by qiudeyang on 19/01/17.
 */
public class HasPath_66 {
    public static boolean hasPath(char[][] matrix,String str){
        if (matrix == null){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (rows < 1|| cols < 1 || str == null || str.length() == 0){
            return false;
        }
        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix,rows,cols,row,col,str,pathLength,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean hasPathCore(char[][] matrix,int rows,int cols,int row,int col,String str,int pathLength,boolean[][] visited){
        if (pathLength == str.length()){
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols && matrix[row][col] == str.charAt(pathLength) && !visited[row][col]){
            pathLength++;
            visited[row][col] = true;
            hasPath = hasPathCore(matrix,rows,cols,row-1,col,str,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row+1,col,str,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row,col-1,str,pathLength,visited)
                    ||hasPathCore(matrix,rows,cols,row,col+1,str,pathLength,visited);
            if (!hasPath){
                pathLength--;
                visited[row][col]=false;
            }
        }
        return hasPath;
    }
    public static void main(String[] args) {
        char[][] matrix = {{'a','b','c','e'},
                {'s','f','c','s'},
                {'a','d','e','e'}};
        System.out.println(hasPath(matrix,"abcb"));
    }
}
