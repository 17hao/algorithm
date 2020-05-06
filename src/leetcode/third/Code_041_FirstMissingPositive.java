package leetcode.third;

/**
 * 第一个缺失的正数
 * 时间复杂度O(n) 空间复杂度O(1)
 * <p>
 * 对于符合范围要求的nums[i], 映射到下标: nums[i] - 1, 例如 1 -> 0, 2 -> 1, 3 -> 2
 *
 * @since 2020-5-6 Wednesday 15:45
 */
public class Code_041_FirstMissingPositive {
    static int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return (i + 1);
            }
        }
        return len + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{1, 1, 1, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 3}));
        System.out.println(firstMissingPositive(new int[]{0, 1, 2, 3}));
        System.out.println(firstMissingPositive(new int[]{0}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{10}));
        System.out.println(firstMissingPositive(new int[]{99, 100}));
        System.out.println(firstMissingPositive(new int[]{1, 100}));
        System.out.println(firstMissingPositive(new int[]{1, -1}));
    }
}
