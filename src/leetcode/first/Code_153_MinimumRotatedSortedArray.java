package leetcode.first;

/**
 * 寻找旋转排序数组中的最小值
 *
 * @since 2020-4-14 Tuesday 22:56 - 23:06
 */
public class Code_153_MinimumRotatedSortedArray {
    static int findMin(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int l = 0, r = len - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[l] < nums[mid]) {
                l = mid;
            } else if (nums[l] > nums[mid]) {
                r = mid;
            } else {
                break;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{3, 4, 0, 1, 2}));
        System.out.println(findMin(new int[]{3, 4, 5, 6, 0, 1}));
        System.out.println(findMin(new int[]{2, 1}));
        System.out.println(findMin(new int[]{1}));
        System.out.println(findMin(new int[]{1, 2, 3}));
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(findMin(new int[]{1, 2}));
    }
}
