package leetcode.third;

/**
 * 寻找2个有序数组的中位数
 * 时间复杂度O(log(m + n))
 * <p>
 * 根据中位数的定义,将问题转换成求2个有序数组第k大的元素,然后相加除以2, 这样可以将奇数和偶数数量的数组合并求解
 *
 * @since 2020-5-19 Tuesday 13:50 - 14:50
 */
public class Code_004_MedianOfTwoSortedArr {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
        return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) +
                getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;
    }

    private static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1, len2 = end2 - start2 + 1;
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int x = start1 + Math.min(len1, k / 2) - 1;
        int y = start2 + Math.min(len2, k / 2) - 1;
        if (nums1[x] > nums2[y]) {
            return getKth(nums1, start1, end1, nums2, y + 1, end2, k - (y - start2 + 1));
        } else {
            return getKth(nums1, x + 1, end1, nums2, start2, end2, k - (x - start1 + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1}, new int[]{2, 4, 6, 8, 10}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10}));
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4, 5}));
        System.out.println(findMedianSortedArrays(new int[]{3, 4, 5}, new int[]{1, 2}));
        System.out.println(findMedianSortedArrays(new int[]{2, 3}, new int[]{1}));
    }
}
