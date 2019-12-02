package leetcode.twice;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回n对括号组成的有效括号组合
 *
 * @since 12-2 Monday
 */
public class Code_022_ParenthesisGenerator {
    static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        dfs("", n, n, result);
        return result;
    }

    static void dfs(String curPar, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(curPar);
            return;
        }

        if (left > 0) {
            dfs(curPar + "(", left - 1, right, result);
        }

        if (left < right) {
            dfs(curPar + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(0));
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
    }
}
