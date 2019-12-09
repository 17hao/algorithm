package leetcode.twice;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个由2-9组成的字符串, 返回它们表示的所有字母组合.
 *
 * @since 2019-12-9 Monday
 */
public class Code_017_LetterCombinations {
    static List<String> letterCombinations(String digits) {
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new LinkedList<>();
        if (digits.length() == 0) return result;
        result.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = Character.getNumericValue(digits.charAt(i));
            String s = mapping[num];
            while (result.get(0).length() == i) {
                for (int j = 0; j < s.length(); j++) {
                    String temp = result.get(0);
                    result.add(temp + s.charAt(j));
                }
                result.remove(0);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("27"));
    }
}
