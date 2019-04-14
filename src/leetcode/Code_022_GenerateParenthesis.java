package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 17hao
 * @date 2019-04-14 18:51
 */
public class Code_022_GenerateParenthesis {
    //todo 这么简单的题还没理解。。。我操
    public static void main(String[] args) {
        int n = 2;
        List res = generateParenthesis(n);
        System.out.println(res);
    }

    private static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, 0, n);
        return list;
    }

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
