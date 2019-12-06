package leetcode.third;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出n对括号能组成的有效括号组合
 *
 * @since 2019-12-6 Friday
 */
public class Code_022_ParenthesisGenerator {
    List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", n, n, result);
        return result;
    }

    void helper(String curPar, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(curPar);
        }
        if (left > 0) {
            helper(curPar + "(", left - 1, right, result);
        }
        if (left < right) {
            helper(curPar + ")", left, right - 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code_022_ParenthesisGenerator().generateParenthesis(1));
        System.out.println(new Code_022_ParenthesisGenerator().generateParenthesis(3));
        System.out.println(new Code_022_ParenthesisGenerator().generateParenthesis(5));
    }
}
