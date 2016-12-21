package org.dalvin.chapter3;

/**
 * Created by qiudeyang on 21/12/16.
 */
public class OddBeforeEven_14 {
    public static void oddBeforeEven(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int head = 0;
        int tail = nums.length - 1;
        while (head < tail) {
            while (head < tail && !isEven(nums[head]) ){
                head++;
            }
            while (head < tail && isEven(nums[tail])){
                tail--;
            }
            if (head < tail){
                int temp = nums[head];
                nums[head] = nums[tail];
                nums[tail] = temp;
            }
        }
    }
    public static boolean isEven(int n){
        return (n & 1) == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,4,6,1,3,5};
        oddBeforeEven(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+"\t");
        }
    }
}
