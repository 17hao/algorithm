package leetcode.second;

/**
 * 搜索旋转数组2(数组中可能有重复元素)
 *
 * @since 2020-3-30
 */
public class Code_081_SearchRotatedSortedArr2 {
    static boolean search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return false;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return true;
            if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            if (nums[left] < nums[mid]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                continue;
            }
            if (nums[left] > nums[mid]) {
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
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3));
    }
}
