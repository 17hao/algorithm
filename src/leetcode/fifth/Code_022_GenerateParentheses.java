package leetcode.fifth;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号生成
 *
 * @since 2020-4-6 Monday 20:32
 */
public class Code_022_GenerateParentheses {
    static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(n, n, res, "");
        return res;
    }

    private static void helper(int l, int r, List<String> res, String temp) {
        if (l == 0 && r == 0) {
            res.add(temp);
            return;
        }
        if (l > 0) {
            helper(l - 1, r, res, temp + "(");
        }
        if (r > l) {
            helper(l, r - 1, res, temp + ")");
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(3));
    }
}
