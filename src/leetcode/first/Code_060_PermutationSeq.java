package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 全排列序列
 *
 * @since 2020-6-5 Friday 17:28
 */
public class Code_060_PermutationSeq {
    String getPermutation(int n, int k) {
        List<Integer> l = new ArrayList<>();
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i;
        }
        dfs(0, n, k, new boolean[n + 1], fac, l);
        StringBuilder builder = new StringBuilder();
        for (Integer i : l) {
            builder.append(i);
        }
        return builder.toString();
    }

    private void dfs(int index, int n, int k, boolean[] used, int[] fac, List<Integer> res) {
        if (index == n) {
            return;
        }
        int cnt = fac[n - 1 - index];
        for (int i = 1; i <= n; i++) {
            if (used[i]) {
                continue;
            }
            if (cnt < k) {
                k -= cnt;
                continue;
            }
            res.add(i);
            used[i] = true;
            dfs(index + 1, n, k, used, fac, res);
        }
    }

    public static void main(String[] args) {
        Code_060_PermutationSeq c = new Code_060_PermutationSeq();
        System.out.println(c.getPermutation(4, 9));
        System.out.println(c.getPermutation(3, 3));
        System.out.println(c.getPermutation(0, 0));
    }
}
