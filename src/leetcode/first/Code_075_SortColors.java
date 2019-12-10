package leetcode.first;

import static tool.CommonTool.*;

/**
 * 荷兰旗问题
 *
 * @author sqh
 * @date 2018-12-18
 */
public class Code_075_SortColors {
    public static void sortColors(int[] num) {
        int small = -1, big = num.length;
        int cur = 0;
        while (cur < big) {
            if (num[cur] < 1) {
                swap(num, ++small, cur++);
            } else if (num[cur] > 1) {
                swap(num, --big, cur);
            } else {
                cur++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = generateArray(10, 10);
        sortColors(arr);
        printArray(arr);
    }
}
