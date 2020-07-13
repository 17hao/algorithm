package leetcode.second;

/**
 * 搜索旋转数组中的最小值
 * 
 * @since 2020-7-13 Monday 17：08 - 17:19
 */
public class Code_153_MinNumInRotatedSortedArr {
    static int findMin(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (l == 0 && r == 0) {
                return nums[0];
            }
            if (nums[m] > nums[m + 1]) {
                return nums[m + 1];
            }
            if (nums[m] > nums[len - 1]) {
                l = m;
            } else {
                r = m;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 2 }));
        System.out.println(findMin(new int[] { 2, 3, 4, 1 }));
        System.out.println(findMin(new int[] { 2, 3, 4 }));
        System.out.println(findMin(new int[] { 3, 4, 1, 2 }));
        System.out.println(findMin(new int[] { 4, 1, 2, 3 }));
    }
}