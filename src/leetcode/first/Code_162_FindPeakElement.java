package leetcode.first;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 *
 * @since 2019-12-27 Friday
 */
public class Code_162_FindPeakElement {
    static int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        for (; l < r; ) {
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
        System.out.println(findPeakElement(new int[]{1, 2, 3, 4}));
        System.out.println(findPeakElement(new int[]{1, 7, 3, 4}));
        System.out.println(findPeakElement(new int[]{1, 7, 3, 1}));
        System.out.println(findPeakElement(new int[]{1}));
        System.out.println(findPeakElement(new int[]{1, 3}));
        System.out.println(findPeakElement(new int[]{5, 3}));
    }
}
