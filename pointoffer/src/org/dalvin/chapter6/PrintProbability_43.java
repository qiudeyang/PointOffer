package org.dalvin.chapter6;

/**
 * Created by qiudeyang on 05/02/17.
 */
public class PrintProbability_43 {
    //以下是递归解法
    public static int gMaxValue = 6;

    public static void printProbabilityRecursive(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = number * gMaxValue;
//      probabilities不同色子数出现次数的计数数组
        int[] probabilities = new int[maxSum - number + 1];
        printProbabilityRecursiveCore(number,probabilities);
        double total = Math.pow(gMaxValue,number);
        for (int i = number; i <= maxSum ; i++) {
            double ratio = probabilities[i-number]/total;
            System.out.print(i+":"+ratio+"\t");
        }
    }

    public static void printProbabilityRecursiveCore(int number,int[] probabilities){
        for (int i = 1; i <= gMaxValue ; i++) {
            printProbabilityRecursiveCore(number,number,i,probabilities);
        }
    }
    //重载printProbabilityRecursiveCore方法,original是总的色子数,current是当前处理的第几个，sum是已经前面的色子数和。
    public static void printProbabilityRecursiveCore(int original,int current,int sum,int[] probabilities){
        if (current == 1){
            probabilities[sum-original]++;
        }else{
            for (int i = 1; i <= gMaxValue ; i++) {
                printProbabilityRecursiveCore(original,current-1,sum+i,probabilities);
            }
        }
    }

    //以下是循环解法
    public static void printProbabilityLoop(int number) {
        if (number < 1) {
            return;
        }
        int maxSum = gMaxValue * number;
        int[][] probabilities = new int[2][maxSum+1];
        //flag用来区分是使用第0个数组还是第1个数组
        int flag = 0;
        //投出1个色子的情况
        for (int i = 1; i <= gMaxValue ; i++) {
            probabilities[flag][i]=1;
        }
        //投出其它色子
        for (int k = 2; k <= number; k++) {
            //如果投出了k个色子，那么和为[0,k-1]的出现次数为0.
            for (int i = 0; i < k; i++) {
                probabilities[1-flag][i]=0;
            }
            //投出k个色子，所有和的可能性。
            for (int i = k; i <= k * gMaxValue ; i++) {
                probabilities[1-flag][i]=0;
                for (int j = 1; j <= i && j <= gMaxValue ; j++) {
                    //统计出和为i的点数出现的次数
                    probabilities[1-flag][i] += probabilities[flag][i-j];
                }
            }
            flag = 1 - flag;
        }

        double total = Math.pow(gMaxValue,number);
        for (int i = number; i <= maxSum ; i++) {
            double ratio = probabilities[flag][i]/total;
            System.out.print(i+":"+ratio+"\t");
        }
    }

    public static void main(String[] args) {
        int number = 2;
        printProbabilityRecursive(number);
        System.out.println();
        printProbabilityLoop(number);
    }
}
