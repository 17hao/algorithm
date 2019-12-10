package leetcode.first;

/**
 * @author 17hao
 * @date 2019-04-25 16:31
 */
public class Code_287_DuplicateNumber {
    private static int duplicateNumber(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[i] == arr[j])
                    res = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 3, 4, 2};
        int res = duplicateNumber(arr);
        System.out.println(res);
    }
}
