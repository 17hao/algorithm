package leetcode.zeroth;

/**
 * 输出节点由1~n组成的二叉搜索树的数量.
 * 设i为根节点的BST数量为f(i), 1~n组成的BST数量G(n) = f(1) + f(2) + ... + f(n)
 * 设n为根节点的BST左节点数量为i - 1, 右节点数量n - i. f(n) = G(i - 1) * G(n - i)
 * G(n) = G(0) * G(n - 1) + G(1) * G(n - 2) + ... + G(n - 1) * G(0)
 *
 * @since 2019-12-4 Wednesday
 */
public class Code_096_UniqueBST {
    static int numTree(int n) {
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
        System.out.println(numTree(1));
        System.out.println(numTree(3));
        System.out.println(numTree(5));
    }
}
