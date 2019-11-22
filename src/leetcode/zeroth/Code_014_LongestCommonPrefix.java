package leetcode.zeroth;

/**
 * @author 17hao
 * @date 2019-05-02 14:58
 */
public class Code_014_LongestCommonPrefix {
    private static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        else {
            String res = "";
            boolean f = true;
            for (int i = 1; i <= strs[0].length() && f; i++) {
                String subStr = strs[0].substring(0, i);
                String temp = subStr.substring(0, subStr.length() - 1);
                for (String s : strs) {
                    if (!s.substring(0, Math.min(i, s.length())).equals(subStr)) {
                        f = false;
                        res = temp;
                        break;
                    } else {
                        res = subStr;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        String res = longestCommonPrefix(strings);
        System.out.println(res);
    }
}
