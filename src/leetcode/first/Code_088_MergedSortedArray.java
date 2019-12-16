package leetcode.first;

import java.util.Arrays;

/**
 * 合并2个有序数组
 *
 * @since 2019-12-16 Monday
 */
public class Code_088_MergedSortedArray {
    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int end = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[end--] = nums1[p1] < nums2[p2] ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    public static void main(String[] args) {
        int[] n1 = {6, 7, 8, 9, 0, 0, 0};
        int[] n2 = {1, 2, 3};
        int[] n3 = {0};
        int[] n4 = {1};
        int[] n5 = {0};
        merge(n1, 4, n2, 3);
        merge(n3, 0, n4, 1);
        merge(n4, 1, n5, 0);
        System.out.println(Arrays.toString(n1));
        System.out.println(Arrays.toString(n3));
    }
}
