package org.dalvin.chapter2;

/**
 * Created by qiudeyang on 11/01/17.
 */
//想兑换100元钱，有1,2,5,10四种钱，问总共有多少兑换方法
public class CoinExchange {
    private static final int n = 100;
    private static int[] dimes = {1, 2, 5, 10};
    private static int m = 4;

    public static int coinExchangeRecursivelly(int n, int m) {
        if (n == 0) {
            return 1;
        }
        if (n < 0 || m == 0) {
            return 0;
        }
        return coinExchangeRecursivelly(n, m - 1) + coinExchangeRecursivelly(n - dimes[m - 1], m);
    }

    public static int coinExchangeUnrecursivelly(int n) {
        int[] array = new int[n+1];
        array[0]=1;
        int i;
        int j;
        for (i = 0; i < dimes.length; i++) {
            for (j = dimes[i]; j <=n ; j++) {
                array[j] += array[j-dimes[i]];  //类似coinExchangeRecursivelly(n, m - 1) + coinExchangeRecursivelly(n - dimes[m - 1], m);
            }
        }
        return array[n];
    }

    public static void main(String[] args) {
        System.out.println(coinExchangeRecursivelly(n, m));
        System.out.println(coinExchangeUnrecursivelly(n));
    }
}
