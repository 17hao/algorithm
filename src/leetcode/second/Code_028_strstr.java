package leetcode.second;

/**
 * 实现string.h中的strstr函数
 * 
 * @since 2020-8-5 Wednesday 16:00
 */
public class Code_028_strstr {
    static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0, j = 0;
        int[] pmt = getPmt(needle.toCharArray());
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else if (pmt[j] == -1) {
                i++;
            } else {
                j = pmt[j];
            }
        }
        return j == needle.length() ? i - j : -1;
    }

    private static int[] getPmt(char[] str) {
        if (str.length == 1) {
            return new int[] { -1 };
        }
        int[] pmt = new int[str.length];
        pmt[0] = -1;
        int pos = 2, cnd = 0;
        while (pos < pmt.length) {
            if (str[pos - 1] == str[cnd]) {
                pmt[pos++] = ++cnd;
            } else if (cnd > 0) {
                cnd = pmt[cnd];
            } else {
                pmt[pos++] = 0;
            }
        }
        return pmt;
    }

    public static void main(String[] args) {
        System.out.println(strStr("", "")); // 0
        System.out.println(strStr("", "a")); // -1
        System.out.println(strStr("a", "")); // 0
        System.out.println(strStr("haystack", "ay"));
        System.out.println(strStr("haystack", "ay"));
        System.out.println(strStr("haystack", "yst"));
    }
}