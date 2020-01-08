package leetcode.first;

/**
 * 寻找缺失的第一个正整数
 *
 * @since 2020-1-8
 */
public class Code_041_FirstMissingPositive {
    int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Code_041_FirstMissingPositive c = new Code_041_FirstMissingPositive();
        System.out.println(c.firstMissingPositive(new int[]{2, 1, 4, 3}));
        System.out.println(c.firstMissingPositive(new int[]{0, 2, 3, 4}));
        System.out.println(c.firstMissingPositive(new int[]{6, 4, 9}));
    }
}
