package tool;

import java.util.Arrays;

/**
 * quick sort
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = new int[]{4, 1, 2, 1, 6};
        sort(a, 0, 4);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] nums, int l, int r) {
        if (nums.length < 2) return;
        if (l < r) {
            int[] tmp = partition(nums, l, r);
            sort(nums, l, tmp[0] - 1);
            sort(nums, tmp[1] + 1, r);
        }
    }

    /**
     * 基础版本快排采用数组最后一个元素作为轴进行划分, 改良版随机选一个轴, 避免6,5,4,3,2,1这样的极端案例使时间复杂度退化成O(n^2).
     */
    private static int[] partition(int[] nums, int l, int r) {
        int i = l - 1, j = r;
        while (l < j) {
            if (nums[l] < nums[r]) {
                swap(nums, ++i, l++);
            } else if (nums[l] == nums[r]) {
                l++;
            } else {
                swap(nums, --j, l);
            }
        }
        swap(nums, r, j);
        return new int[]{i + 1, j};
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
