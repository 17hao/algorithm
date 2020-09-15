package nowcoder.basic.section_1;

public class Solution_4 {
    static boolean find(int target, int[][] array) {
        boolean result = false;
        for (int[] a : array) {
            result = binarySearch(target, a);
            if (result) {
                break;
            }
        }
        return result;
    }

    static boolean binarySearch(int target, int[] a) {
        boolean result = false;
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target < a[mid]) {
                hi = mid - 1;
            } else if (target > a[mid]) {
                lo = mid + 1;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int target = 6;
        int[][] a = {{0, 1, 2, 3}, {4, 5, 6, 7}};
        System.out.println(find(target, a));
    }
}
