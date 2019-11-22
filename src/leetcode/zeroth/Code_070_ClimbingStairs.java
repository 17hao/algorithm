package leetcode.zeroth;

/**
 * @author 17hao
 * @date 2019-04-17 21:24
 */
public class Code_070_ClimbingStairs {
    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int res = 0;
        for (int i = 3; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int res = climbStairs(n);
        System.out.println(res);
    }
}
