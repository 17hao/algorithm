package leetcode.second;

import java.util.HashMap;

/**
 * 罗马数字转整数
 *
 * @since 2019-12-11 Wednesday
 */
public class Code_013_RomanToInt {
    static int romanToInt(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);
        int index = s.length() - 1;
        int result = 0;
        while (index >= 0) {
            if (index == 0) {
                result += map.get(s.charAt(index--));
            } else {
                int lower = map.get(s.charAt(index));
                int higher = map.get(s.charAt(index - 1));
                if (higher < lower) {
                    result = result + lower - higher;
                    index -= 2;
                } else {
                    result += lower;
                    index--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt(""));
        System.out.println(romanToInt("M"));
        System.out.println(romanToInt("CM"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
    }
}
