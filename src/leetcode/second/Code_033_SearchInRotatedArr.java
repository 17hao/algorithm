package leetcode.second;

/**
 * 搜索旋转排序数组
 *
 * @since 2019-12-21 Saturday
 */
public class Code_033_SearchInRotatedArr {
    int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int rotateIndex = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) break;
            int mid = (l + r) >>> 1;
            if (nums[mid] > nums[mid + 1]) {
                rotateIndex = mid + 1;
                break;
            } else if (nums[mid] < nums[0]) {
                r = mid;
            } else if (nums[mid] > nums[0]) {
                l = mid;
            }
        }
        return Math.max(binarySearch(nums, 0, rotateIndex - 1, target),
                binarySearch(nums, rotateIndex, nums.length - 1, target));
    }

    private int binarySearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code_033_SearchInRotatedArr().search(new int[]{1}, 0));
        System.out.println(new Code_033_SearchInRotatedArr().search(new int[]{1}, 1));
        System.out.println(new Code_033_SearchInRotatedArr().search(new int[]{1, 3}, 1));
        System.out.println(new Code_033_SearchInRotatedArr().search(new int[]{3, 1}, 1));
        System.out.println(new Code_033_SearchInRotatedArr().search(new int[]{4, 5, 6, 7, 8, 9, 0, 1, 2}, 0));
        System.out.println(new Code_033_SearchInRotatedArr().search(new int[]{4, 5, 6, -1, 0, 1, 2}, 3));
    }
}
