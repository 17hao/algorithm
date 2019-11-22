package leetcode.zeroth;

/**
 * @author 17hao
 * @date 2019-04-25 16:18
 */
public class Code_268_MissingNumber {
    private static int missingNumber(int[] arr) {
        int sum = arr.length * (arr.length + 1) / 2;
        for (int n : arr) {
            sum -= n;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 0, 1};
        int res = missingNumber(arr);
        System.out.println(res);
    }
}
