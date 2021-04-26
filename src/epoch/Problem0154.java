package epoch;

/**
 * 寻找旋转数组的最小值. 数组中有重复元素
 * 
 * 关键是找到数组旋转的轴.
 * 通过二分查找, 如果中间值大于中间值右边的值,则该中间值就是旋转的轴
 * 否则, 如果中间值小于最左边的值, 中间值在最左边和当前中间值之间
 * 如果中间值大于最右边的值, 中间值在当前中间值和最右边之间
 * 否则, 右边界缩小一位
 * 如果直到最左和最右的下标相等还没找到旋转轴, 返回-1
 * 
 * @since 2021-4-26 Monday 11:43 - 12:16
 */
public class Problem0154 {
    public static void main(String... args) {
        int[] n1 = { 4, 5, 6, 7, 0, 1, 2, 3 };
        int[] n2 = { 4, 5, 6, 7, 0, 1 };
        int[] n3 = { 7, 0, 1, 2, 3, 4 };
        int[] n4 = { 1, 2, 3, 4 };
        Problem0154 p = new Problem0154();
        System.out.println(p.findMin(n1));
        System.out.println(p.findMin(n2));
        System.out.println(p.findMin(n3));
        System.out.println(p.findMin(n4));
    }

    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        return nums[pivot + 1];
    }

    private int findPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return mid;
            }
            if (nums[mid] < nums[l]) {
                r = mid;
            } else if (nums[mid] > nums[r]) {
                l = mid;
            } else {
                r--;
            }
        }
        return -1;
    }
}