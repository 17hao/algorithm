package leetcode.first;

import tool.CommonTool;

/**
 * 加一
 *
 * @author sqh
 * @date 2018/12/17
 */
public class Code_066_PlusOne {
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        int[] arr = CommonTool.generatePositiveArray(10, 10);
        int[] res = plusOne(arr);
        CommonTool.printArray(res);
    }
}
