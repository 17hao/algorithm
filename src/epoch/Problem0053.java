package epoch;

import java.util.Scanner;

/**
 * 最大子序和
 *
 * @since 2021-4-6 Tuesday 22:40 - 23:08
 */
public class Problem0053 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String[] strings = scanner.next().split(" ");
        int[] nums = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            nums[i] = Integer.parseInt(strings[i]);
        }
        System.out.println(maxSubArray(nums));
    }

    static int maxSubArray(int[] nums) {
        int window = nums[0];
        int res = window;
        for (int i = 1; i < nums.length; i++) {
            if (window < 0) {
                window = nums[i];
            } else {
                window += nums[i];
            }
            res = Math.max(res, window);
        }
        return res;
    }
}
