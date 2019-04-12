package leetcode;

import java.util.HashMap;

/**
 * @author 17hao
 * @date 2019-04-12 19:44
 */
public class Code_013_RomanToInteger {
    static int romanToInt(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("I", 1);
        hm.put("V", 5);
        hm.put("X", 10);
        hm.put("L", 50);
        hm.put("C", 100);
        hm.put("D", 500);
        hm.put("M", 1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if ()
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "M";
        int res = romanToInt(str);
        System.out.println(res);
    }
}
