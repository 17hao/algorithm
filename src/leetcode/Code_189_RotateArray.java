package leetcode;

public class Code_189_RotateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 5;
        rotate(nums, k);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    static void rotate(int[] nums, int k) {
        int real = k % nums.length;
        int begin = nums.length - real;
        for (int i = begin; i < nums.length; i++) {
            for (int j = i; j > i - (nums.length - real); j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    private static void swap(int[] nums, int i, int k) {
        int tmp = nums[i];
        nums[i] = nums[k];
        nums[k] = tmp;
    }
}
