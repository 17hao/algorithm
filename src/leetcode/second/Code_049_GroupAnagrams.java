package leetcode.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @since 2019-12-21 Saturday
 */
public class Code_049_GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (map.containsKey(s)) {
                List<String> l = map.get(s);
                l.add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(s, l);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
