package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 *
 * @since 2020-6-11 Thursday 12:39
 */
public class Code_077_Combinations {
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 0 || n < k) {
            return res;
        }

        _helper(n, k, 1, res, new ArrayList<>());
        return res;
    }

    private static void helper(int n, int k, int begin, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = begin; i <= n; i++) {
            tmp.add(i);
            helper(n, k, i + 1, res, tmp);
            // tmp.remove(Integer.valueOf(i));
            tmp.remove(tmp.size() - 1);
        }
    }

    private static void _helper(int n, int k, int begin, List<List<Integer>> res, List<Integer> tmp) {
        if (tmp.size() == k) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = begin; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            helper(n, k, i + 1, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(4, 3));
        System.out.println(combine(4, 4));
    }
}
