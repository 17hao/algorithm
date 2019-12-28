package leetcode.second;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * @since 2019-12-28 Saturday 15:33
 */
public class Code_169_MajorityElement {
    static int majorityElement(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == result) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                result = nums[i + 1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1, 1, 1, 3, 4}));
        System.out.println(majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
