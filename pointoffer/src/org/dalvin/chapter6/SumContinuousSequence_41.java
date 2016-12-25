package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 24/12/16.
 */
public class SumContinuousSequence_41 {
    public static boolean sumContinuousSequence(int target) {
        boolean found = false;
        if (target < 3) {
            return found;
        }
        int start = 1;
        int end = 2;
        int middle = (target - 1) / 2;
        int sum = start+end;
        while (start <= middle) {
            if (target == sum) {
                found = true;
                printNumber(start,end);
            }
            while (sum > target && start <= middle){
                sum -= start;
                start++;
                if(sum == target){
                    found = true;
                    printNumber(start,end);
                }
            }
            end++;
            sum += end;
        }
        return found;
    }
    public static void printNumber(int start,int end){
        for (int i = start; i <= end ; i++) {
            System.out.print(i+"\t");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int target = 9;
        System.out.println(sumContinuousSequence(target));
    }
}
