package leetcode.fourth;

/**
 * 找到2个正序数组的中位数，时间复杂度O(log(m+n))
 * 将问题转换成找到2个数组第k大的问题
 * 2个数组的中位数涉及到奇数偶数个数，将2种情况统一，也就是找到2个数组第(m + n + 1) / 2和(m + n + 2) / 2大的2个数.第k大的数
 * 借鉴2分查找的思想：每次找k / 2 大的数字，取每个数组第`min(k / 2, last)`个数字进行比较，小的那个数组说明前k / 2 个数都不会是第k大的数，所以全部排除
 * 递归查找，直到k = 1或者有一个数组长度为0，返回结果
 * 
 * @since 2020-8-10 Monday 11:40 - 12:13
 */
public class Code_004_MedianOfTwoSortedArr {
    static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int k1 = (m + n + 1) / 2, k2 = (m + n + 2) / 2;
        return (helper(nums1, 0, m - 1, nums2, 0, n - 1, k1) + helper(nums1, 0, m - 1, nums2, 0, n - 1, k2)) / 2;
    }

    private static double helper(int[] n1, int s1, int e1, int[] n2, int s2, int e2, int k) {
        int l1 = e1 - s1 + 1, l2 = e2 - s2 + 1;
        if (l1 == 0) {
            return n2[s2 + k - 1];
        } 
        if (l2 == 0) {
            return n1[s1 + k - 1];
        }
        if (k == 1) {
            return Math.min(n1[s1], n2[s2]);
        }
        int start1 = Math.min(e1, s1 + k / 2 - 1), start2 = Math.min(e2, s2 + k / 2 - 1);
        int tmp1 = n1[start1], tmp2 = n2[start2];
        if (tmp1 > tmp2) {
            return helper(n1, s1, e1, n2, start2 + 1, e2, k - (start2 - s2 + 1));
        } else {
            return helper(n1, start1 + 1, e1, n2, s2, e2, k - (start1 - s1 + 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] { 2, 4, 5, 6 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 2, 4, 5, 6 }));
        System.out.println(findMedianSortedArrays(new int[] { 1 }, new int[] { 2, 3, 4, 5 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3, 4, 5, 6, 7 }, new int[] { 0 }));
        System.out.println(findMedianSortedArrays(new int[] {}, new int[] { 2, 4, 5, 6 }));
        System.out.println(findMedianSortedArrays(new int[] { 1, 2, 3 }, new int[] {}));
    }
}