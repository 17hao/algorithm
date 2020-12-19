package leetcode.third;

import java.util.Arrays;
import java.util.Random;

/**
 * 打乱一个数组
 * 
 * @since 2020-7-8 Wednesday 19:15
 */
public class Code_384_Shuufle {
    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        Solution s = new Solution(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.reset()));
    }
}

class Solution {

    private int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        for (int i = tmp.length - 1; i >= 0; i--) {
            int randomIndex = new Random().nextInt(tmp.length - i) + i;
            swap(tmp, i, randomIndex);
        }
        return tmp;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}