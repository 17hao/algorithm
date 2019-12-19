package leetcode.first;

/**
 * 旋转图像
 *
 * @since 2019-12-19 Thursday
 */
public class Code_048_RotateImage {
    static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] m = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(m);
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        //System.out.println(Arrays.deepToString(m));
    }
}
