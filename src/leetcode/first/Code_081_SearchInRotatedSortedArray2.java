package leetcode.first;

/**
 * 搜索旋转排序数组2(数组中有重复数字)
 *
 * @since 2020-3-27 Friday 17:10
 */
public class Code_081_SearchInRotatedSortedArray2 {
    static boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return false;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (nums[mid] <= nums[right]) {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 7, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
        System.out.println(search(new int[]{3, 1, 1}, 0));
        System.out.println(search(new int[]{1, 3, 5}, 1));
    }
}
