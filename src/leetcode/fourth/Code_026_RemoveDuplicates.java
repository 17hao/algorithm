package leetcode.fourth;

/**
 * 删除重复元素
 * 返回移除后数组的新长度
 *
 * @since 2020-6-15 Monday 16:16
 */
public class Code_026_RemoveDuplicates {
    static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int res = 0, cur = 1;
        while (cur < len) {
            if (nums[cur] == nums[res]) {
                cur++;
            } else {
                nums[++res] = nums[cur];
            }
        }
        return res + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 2, 2, 2, 3};
        // int[] arr = new int[]{1, 2, 2, 2};
        int res = removeDuplicates(arr);
        for (int i = 0; i < res; i++) {
            System.out.println(arr[i]);
        }
    }
}
