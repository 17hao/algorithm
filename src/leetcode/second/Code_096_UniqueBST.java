package leetcode.second;

/**
 * 求由1~n为节点组成的BST数量
 * 设由1~n为节点的BST数量G(n). 以i为根节点的BST数量为f(i).
 * G(n) = f(1) + f(2) + ... + f(n)
 * 为i根节点的BST左子树数量为G(j - 1), 右子树数量为G(i - j).
 * f(i) = G(j - 1) * G(i - j)
 * 综上得出G(n) = G(0) * G(N - 1) + G(1) * G(N - 2) + ... + G(N - 1) *G(0)
 *
 * @since 2019-12-5 Thursday
 */
public class Code_096_UniqueBST {
    static int uniqueBST(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(uniqueBST(1));
        System.out.println(uniqueBST(3));
        System.out.println(uniqueBST(7));
    }
}
