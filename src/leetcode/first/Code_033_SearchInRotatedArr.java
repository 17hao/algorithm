package leetcode.first;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * @since 2019-12-13 Friday
 */
public class Code_033_SearchInRotatedArr {
    int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int rotatedIndex = findRotatedIndex(nums);
        if (rotatedIndex == 0) return binarySearch(nums, 0, nums.length - 1, target);
        if (target == nums[rotatedIndex]) {
            return rotatedIndex;
        } else if (target < nums[0]) {
            return binarySearch(nums, rotatedIndex, nums.length - 1, target);
        }
        return binarySearch(nums, 0, rotatedIndex - 1, target);
    }

    private int findRotatedIndex(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (nums[left] < nums[right]) return 0;
        while (left < right) {
            int pivot = (left + right) >>> 1;
            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[left] < nums[pivot]) {
                    left = pivot;
                } else {
                    right = pivot;
                }
            }
        }
        return 0;
    }

    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 1, 2, 3};
        int[] nums2 = {1, 3};
        int[] nums3 = {3, 1};
        System.out.println(new Code_033_SearchInRotatedArr().search(nums, 1));
        System.out.println(new Code_033_SearchInRotatedArr().search(nums, 9));
        System.out.println(new Code_033_SearchInRotatedArr().search(nums2, 3));
        System.out.println(new Code_033_SearchInRotatedArr().search(nums3, 3));
    }
}
