package leetcode;

/**
 * @author 17hao
 * @date 2019-04-30 17:24
 */
public class Code_028_strStr {
    private static int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int res = -1;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                for (; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == needle.length()) {
                    res = i;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //"mississippi"
        // "issip"
        String haystack = "mississippi";
        String needle = "issip";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }
}
