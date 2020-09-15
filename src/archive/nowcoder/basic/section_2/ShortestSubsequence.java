package nowcoder.basic.section_2;

/**
 * input: 1, 5, 4, 3, 2, 6, 7
 * output: 4
 */
public class ShortestSubsequence {
    int findShortest(int[] arr, int n) {
        int max = arr[0];
        int min = arr[arr.length - 1];
        int p = 0, q = arr.length - 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= max) max = arr[i];
            else p = i;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] <= min) min = arr[i];
            else q = i;
        }
        if (p == 0 && q == arr.length - 1) return 0;
        else return p - q + 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 3, 2, 6, 7};
        int[] b = {1, 3, 5, 2, 4, 6, 7};
        int[] c = {1, 3};
        int[] d = {3, 1};
        int[] e = {1, 2, 3, 3, 8, 9};
        ShortestSubsequence s = new ShortestSubsequence();
        System.out.println(s.findShortest(e, e.length));
    }
}
