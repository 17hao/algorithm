package leetcode.fourth;

import java.util.List;
import java.util.Random;

/**
 * shuffle
 *
 * @since 2020-12-19 Saturday 12:50
 */
public class Code_384_Shuffle {
    public static void main(String...args) {
        int[] nums = {1,2,3};
        Solution s = new Solution(nums);
        int[] res = s.shuffle();
        for (int i = 0; i < nums.length; i++) {
            System.out.println(res[i] + " ");
        }
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
        int size = nums.length;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = nums[i];
        }
        for (int i = size - 1; i > 0; i--) {
            swap(arr, i, new Random().nextInt(i + 1));
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
