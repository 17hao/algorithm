package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 17hao
 * @date 2019-04-14 18:51
 */
public class Code_022_GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        List res = generateParenthesis(n);
        System.out.println(res);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }

    /* 每次调用会完整的保留整个函数的所有内容，包括形参、局部变量、返回值等 */
    private static void helper(List<String> list, String tmp, int left, int right, int n) {
        if (right == n) {
            list.add(tmp);
            return;
        }
        if (left < n) {
            helper(list, tmp + "(", left + 1, right, n);
        }
        if (right < left) {

            helper(list, tmp + ")", left, right + 1, n);
        }
    }
}
