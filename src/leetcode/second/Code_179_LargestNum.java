package leetcode.second;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @since 2021-2-22 Monday 19:44
 */
public class Code_179_LargestNum {
    public String largestNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = (s1, s2) -> {
            String a = s1 + s2;
            String b = s2 + s1;
            return b.compareTo(a);
        };

        Arrays.sort(strings, comp);
        if (strings[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strings) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Code_179_LargestNum c = new Code_179_LargestNum();
        System.out.println(c.largestNumber(new int[] { 10, 2 }));
        System.out.println(c.largestNumber(new int[] { 1 }));
        System.out.println(c.largestNumber(new int[] { 3, 30, 34, 5, 9 })); // 9534330
        System.out.println(c.largestNumber(new int[] { 0, 1, 0 })); 
        System.out.println(c.largestNumber(new int[] { 0, 0 }));
    }
}
