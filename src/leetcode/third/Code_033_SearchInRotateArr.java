package leetcode.third;

/**
 * 搜索旋转数组
 * 数组中不存在重复元素
 *
 * @since 2020-7-4 Saturday 21:30
 */
public class Code_033_SearchInRotateArr {
    static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int rotateIndex = findRotateIndex(nums);
        return Math.max(binSearch(nums, target, 0, rotateIndex),
                binSearch(nums, target, rotateIndex + 1, nums.length - 1));
    }

    static int binSearch(int[] nums, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    static int findRotateIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) break;
            int mid = l + ((r - l) >>> 1);
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[r]) {
                l = mid;
            } else if (nums[mid] < nums[l]) {
                r = mid;
            }
        }
        return nums.length - 1;
    }

    public static void main(String[] args) {
        // System.out.println(search(new int[]{1}, 1));
        // System.out.println(search(new int[]{1}, 0));
        // System.out.println(search(new int[]{3, 1}, 1));
        // System.out.println(search(new int[]{1, 3}, 1));
        // System.out.println(search(new int[]{1, 3, 4, 5,}, 1));
        // System.out.println(search(new int[]{6, 1, 3, 4, 5,}, 1));
        // System.out.println(search(new int[]{6, 5, 4, 3, 1, 2}, 1));
        System.out.println(search(new int[]{3, 4, 5, 6, 1, 2}, 2));
    }
}
