package leetcode.second;

/**
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 你的解法应该是 O(logN) 时间复杂度的。
 *
 * @since 2019-12-31 Tuesday 14:00
 */
public class Code_162_FindPeekElement {
    static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 3, 1, 2, 5}));
        System.out.println(findPeakElement(new int[]{1, 2, 4, 3, 5, 6, 4}));
        System.out.println(findPeakElement(new int[]{1, 2, 0, 2, 5}));
    }
}
