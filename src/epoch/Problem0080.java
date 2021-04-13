package epoch;

import java.util.Scanner;

/**
 * 删除有序数组中的重复项
 * 原地删除重复出现的元素，每个元素最多出现2次，返回删除后新数组的长度
 * <p>
 * 基于快慢指针，慢指标指向下一个元素应该放的位置，快指针指向当前待检查元素。
 * 如果快指针指向的元素应该被保留，则放到慢指针指向的位置，最后返回慢指针的下标值。
 * 快指针指向元素是否该被保留的条件：nums[fast] != nums[slow - 2]
 *
 * @since 2021-4-13 Tuesday 22:10
 */
public class Problem0080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String[] s = scanner.next().split(" ");
        int[] nums = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        int len = removeDuplicates(nums);
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    static int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int slow = 2, fast = 2;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow - 2]) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}
