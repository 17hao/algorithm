package leetcode.second;

/**
 * 从有序数组中删除重复元素
 *
 * @since 2019-12-15 Sunday
 */
public class Code_026_RemoveDuplicatesFromSortedArr {
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] n1 = {};
        int[] n2 = {1, 1, 2, 3, 4, 5};
        int[] n3 = {1, 2, 2, 3, 4, 5};
        int[] n4 = {1, 2, 3, 3, 3, 4, 5};
        System.out.println(removeDuplicates(n1));
        System.out.println(removeDuplicates(n2));
        System.out.println(removeDuplicates(n3));
        System.out.println(removeDuplicates(n4));
    }
}
