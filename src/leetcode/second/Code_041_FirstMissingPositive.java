package leetcode.second;

/**
 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
 *
 * @since 2020-1-18 Saturday
 */
public class Code_041_FirstMissingPositive {
    static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) return 1;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != (i + 1)) {
                return i + 1;
            }
        }
        return len + 1;
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{1, 2}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
