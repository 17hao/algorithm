package nowcoder.basic.section_2;

public class ShortestSubsequence {
    public int findShortest(int[] A, int n) {
        // write code here
        int max = A[0];
        int min = A[A.length - 1];
        int p = 0, q = A.length - 1;
        for (int i = 1; i < A.length; i++) {
            if (max > A[i])
                p = i;
            else
                max = A[i];
        }
        for (int i = A.length - 2; i >= 0; i--) {
            if (min < A[i])
                q = i;
            else
                min = A[i];
        }
        if (p == 0 && q == A.length - 1)
            return 0;
        else
            return p - q + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2, 6, 7};
        int[] b = {1, 3, 5, 2, 4, 6, 7};
        ShortestSubsequence s = new ShortestSubsequence();
        System.out.println(s.findShortest(b, b.length));
    }
}
