package leetcode.zeroth;

import java.util.HashMap;

/**
 * @author 17hao
 * @date 2019-04-12 19:44
 */
public class Code_013_RomanToInteger {
    private static int romanToInt(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int res = hm.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (hm.get(s.charAt(i)) > hm.get(s.charAt(i - 1))) {
                res += (hm.get(s.charAt(i)) - 2 * hm.get(s.charAt(i - 1)));
            } else {
                res += hm.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "MCMXCIV";
        int res = romanToInt(str);
        System.out.println(res);
    }
}
