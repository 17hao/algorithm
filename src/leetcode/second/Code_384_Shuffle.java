package leetcode.second;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 洗牌算法
 *
 * @since 2020-6-1 Monday 14:05 - 14:35
 */
public class Code_384_Shuffle {
    public static void main(String[] args) {
        Solution s = new Solution(new int[]{1, 2, 3});
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 600; i++) {
            String str = Arrays.toString(s.shuffle());
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        System.out.println(map);
    }
}

class Solution {

    private final int[] nums;

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return nums;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int len = nums.length;
        int[] res = new int[len];
        System.arraycopy(nums, 0, res, 0, len);
        for (int i = 0; i < len; i++) {
            int random = Math.abs(new Random().nextInt(len - i));
            swap(res, i, i + random);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
