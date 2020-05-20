package leetcode.third;

/**
 * 从排序数组中删除重复元素
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @since 2020-5-15 Friday 14:22
 */
public class Code_026_RemoveDuplicatesFromSortedArr {
    static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int i = 0, j = 1;
        while (j < len) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return ++i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3, 3, 4, 4, 5, 5};
        int n = removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n++");
        int[] nums2 = {1, 1, 1, 3, 3, 4, 4, 5, 5};
        n = removeDuplicates(nums2);
        for (int i = 0; i < n; i++) {
            System.out.print(nums2[i] + " ");
        }
        System.out.println("\n++");
        int[] nums3 = {1, 1, 2};
        n = removeDuplicates(nums3);
        for (int i = 0; i < n; i++) {
            System.out.print(nums3[i] + " ");
        }
    }
}
