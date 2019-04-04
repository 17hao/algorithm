package leetcode;

import java.util.Arrays;

/**
 * @author sqh
 * @since 2019/4/4
 */
public class Code_976_LargestPerimeterTriangle {
    private static int largestPerimeterTriangle(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        int res = 0;
        for (int i = length - 1; i >= 2; i--) {
            if (A[i] < A[i - 1] + A[i - 2]) {
                res = A[i] + A[i - 1] + A[i - 2];
                return res;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, 3, 4};
        int res = largestPerimeterTriangle(A);
        System.out.println(res);
    }
}
