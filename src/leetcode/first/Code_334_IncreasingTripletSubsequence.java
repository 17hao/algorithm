package leetcode.first;

/**
 * 判断数组中是否存在长度为 3 的递增子序列
 *
 * @since 20021-1-12 Tuesday 21:15 - 21:32
 */
public class Code_334_IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n <= a) {
                a = n;
            } else if (n <= b) {
                b = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Code_334_IncreasingTripletSubsequence c = new Code_334_IncreasingTripletSubsequence();
//        System.out.println(c.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
//        System.out.println(c.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(c.increasingTriplet(new int[]{6, 2, 2, 67, 1, 43, 4, 1, 56, 0}));
    }
}
