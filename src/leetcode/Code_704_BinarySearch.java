package leetcode;

/**
 * @author 17hao
 * @date 2019-04-25 09:53
 */
public class Code_704_BinarySearch {
    private static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < target)
                low = mid + 1;
            else if (arr[mid] > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int res = binarySearch(arr, target);
        System.out.print(res);
    }
}
