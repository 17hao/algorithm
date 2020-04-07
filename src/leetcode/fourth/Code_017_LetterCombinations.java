package leetcode.fourth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 电话号码组合
 *
 * @since 2020-4-7 Tuesday 21:34 - 21:53
 */
public class Code_017_LetterCombinations {
    static List<String> letterCombinations(String digits) {
        Map<String, String> phone = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        backtrack(res, phone, "", digits);
        return res;
    }

    private static void backtrack(List<String> res, Map<String, String> phone, String combination, String remainingDigits) {
        if (remainingDigits.length() == 0) {
            res.add(combination);
        } else {
            String numbers = phone.get(remainingDigits.substring(0, 1));
            for (int i = 0; i < numbers.length(); i++) {
                backtrack(res, phone, combination + numbers.substring(i, i + 1), remainingDigits.substring(1));
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("234"));
    }
}
