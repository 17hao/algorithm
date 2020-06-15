package leetcode.first;

/**
 * 移除重复元素
 * 每个元素最多出现两次，返回移除后数组的新长度
 *
 * @since 2020-6-15 Monday 17:12
 */
public class Code_080_RemoveDuplicates {
    static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int res = 0;
        for (int n : nums) {
            if (res < 2 || n > nums[res - 2]) {
                nums[res++] = n;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 3};
        int res = removeDuplicates(arr);
        for (int i = 0; i < res; i++) {
            System.out.println(arr[i]);
        }
    }
}
