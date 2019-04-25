package leetcode;

/**
 * @author 17hao
 * @date 2019-04-25 10:00
 */
public class Code_034_FistAndLastPosition {
    private static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        res[0] = first;
        res[1] = last;
        return res;
    }

    private static int findFirst(int[] nums, int target) {
        int first = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == 0 || nums[mid - 1] < target) {
                    first = mid;
                    return first;
                } else {
                    high = mid - 1;
                }
            }
        }
        return first;
    }

    private static int findLast(int[] nums, int target) {
        int last = -1;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (mid == nums.length - 1 || nums[mid + 1] > target) {
                    last = mid;
                    return last;
                } else {
                    low = mid + 1;
                }
            }
        }
        return last;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4};
        int target = 4;
        int[] res = searchRange(arr, target);
        for (int n : res) {
            System.out.println(n);
        }
    }
}
