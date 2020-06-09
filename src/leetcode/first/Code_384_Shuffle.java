package leetcode.first;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 洗牌算法
 *
 * @since 2020-5-21 Thursday
 */
public class Code_384_Shuffle {
    /**
     * Wrong!
     */
    static void shuffleV1(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int rand = Math.abs(new Random().nextInt(len));
            swap(nums, i, rand);
        }
    }

    static void shuffleV2(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int rand = Math.abs(new Random().nextInt(len - i)) + i;
            swap(nums, i, rand);
        }
    }


    static Map<String, Integer> count() {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < 10000; i++) {
            int[] arr = {1, 2, 3};
            shuffleV2(arr);
            String a = Arrays.toString(arr);
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                map.put(a, 1);
            }
        }
        return map;
    }

    static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        // Map<String, Integer> res = count();
        // for (String s : res.keySet()) {
        //     System.out.print(s + " ");
        // }
        // System.out.println();
        // for (int v : res.values()) {
        //     System.out.print(v + " ");
        // }
        int[] arr = {1, 2, 3, 4, 5};
        shuffleV2(arr);
        System.out.println(Arrays.toString(arr));
    }
}

class Solution {
    int[] nums;

    Solution(int[] nums) {
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
        int[] res = new int[nums.length];
        System.arraycopy(nums, 0, res, 0, nums.length);
        int len = res.length;
        for (int i = 0; i < len; i++) {
            int rand = Math.abs(new Random().nextInt(len - i)) + i;
            swap(res, i, rand);
        }
        return res;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Solution obj = new Solution(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));
        System.out.println(Arrays.toString(obj.reset()));
    }
}
