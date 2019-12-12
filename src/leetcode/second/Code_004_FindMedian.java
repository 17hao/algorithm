package leetcode.second;

/**
 * 寻找2个有序数组的中位数
 *
 * @since 2019-12-12 Thursday
 */
public class Code_004_FindMedian {
    double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int left = (l1 + l2 + 1) >>> 1;
        int right = (l1 + l2 + 2) >>> 1;
        return (getKth(nums1, 0, l1 - 1, nums2, 0, l2 - 1, left) +
                getKth(nums1, 0, l1 - 1, nums2, 0, l2 - 1, right)) * 0.5;
    }

    double getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int l1 = end1 - start1 + 1;
        int l2 = end2 - start2 + 1;
        if (l2 > l1) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (l2 == 0) return nums1[start1 + k - 1];
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(k >>> 1, l1) - 1;
        int j = start2 + Math.min(k >>> 1, l2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2};
        int[] n2 = {3};
        int[] n3 = {3, 4, 5, 6};
        // System.out.println(new Code_004_FindMedian().findMedianSortedArrays(n1, n2));
        System.out.println(new Code_004_FindMedian().findMedianSortedArrays(n1, n3));
        // System.out.println(new Code_004_FindMedian().findMedianSortedArrays(n2, n3));
    }
}
