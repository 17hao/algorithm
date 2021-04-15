package epoch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 将数组中的数字组合成最大的整数
 * 按照数组元素两两组合后的大小进行比较, 从大到小排序, 最后将数组元素拼接.
 * 
 * @since 2021-4-15 Thursday 19:09 - 19:50
 */
public class Problem0179 {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String[] s = scanner.next().split(" ");
        scanner.close();
        int[] nums = new int[s.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(largestNumber(nums));
    }

    static String largestNumber(int[] nums) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                int x = i == 0 ? 1 : (int) Math.log10(i) + 1;
                int y = j == 0 ? 1 : (int) Math.log10(j) + 1;
                return (j * (int) Math.pow(10, x) + i) - (i * (int) Math.pow(10, y) + j);
            }
        };

        Integer[] array = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i];
        }
        Arrays.sort(array, comparator);
        if (array[0] == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int n : array) {
            builder.append(n);
        }
        return builder.toString();
    }
}
