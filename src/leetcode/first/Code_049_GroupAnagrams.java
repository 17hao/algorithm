package leetcode.first;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * @since 2019-12-20 Friday
 */
public class Code_049_GroupAnagrams {
    static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String key = String.valueOf(temp);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> l = new ArrayList<>();
                l.add(str);
                map.put(key, l);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
