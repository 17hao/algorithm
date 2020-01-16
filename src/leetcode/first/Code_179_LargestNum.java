package leetcode.first;

import java.util.Arrays;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 *
 * @since 2020-1-16 Thursday
 */
public class Code_179_LargestNum {
    static String largestNum(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(temp, (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        });
        if (temp[0].equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for (String s : temp) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(largestNum(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNum(new int[]{3, 40, 34, 5, 9}));
        System.out.println(largestNum(new int[]{32, 1, 34, 5, 9}));
    }
}
