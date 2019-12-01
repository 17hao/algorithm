package leetcode.onece;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个由2-9组成的字符串, 返回它们表示的所有字母组合.
 *
 * @since 11-30 Saturday
 */
public class Code_017_LetterCombinations {
    static List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            while (i == result.peek().length()) {
                String t = result.pop();
                for (char c : mapping[num].toCharArray()) {
                    result.add(t + c);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "23";
        String s2 = "234";
        System.out.println(letterCombinations(s1));
        System.out.println(letterCombinations(s2));
    }
}
