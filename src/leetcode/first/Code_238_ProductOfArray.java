package leetcode.first;

/**
 * @author 17hao
 * @date 2019-05-02 10:18
 */
public class Code_238_ProductOfArray {
    //todo practice again!
    private static int[] productExceptSelf(int[] arr) {
        int[] res = new int[arr.length];
        int left = 1;
        int right = 1;
        for (int i = 0; i < arr.length; i++) {
            res[i] = left;
            left *= arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int[] res = productExceptSelf(arr);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
