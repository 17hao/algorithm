package misc.first;

/**
 * KMP
 * 
 * @since 2020-8-5 Wednesday 10:09
 */
public class KMP {
    static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() == 0 || m.length() == 0) {
            return -1;
        }
        int[] pmt = getPmtArray(m.toCharArray());
        int i = 0, j = 0;
        while (i < s.length() && j < m.length()) {
            if (s.charAt(i) == m.charAt(j)) {
                i++;
                j++;
            } else if (pmt[j] == -1) {
                i++;
            } else {
                j = pmt[j];
            }
        }
        return j == m.length() ? i - j : -1;
    }

    /**
     * 部分匹配数组（partial match table）
     * m[i]的前缀子串（以m[0]开头且不包含m[i - 1]）和后缀子串（以m[i - 1]结尾且不包含m[0]）的最大交集长度
     * 
     * res[0] = -1（只有后缀没有前缀）
     * res[1] = 0（前缀和后缀都为空字符串）
     * 记录当前位置下标i和m[i - 1]位置最大交集下一个字符下标cur
     * if (arr[i - 1] == arr[cur]) res[i++] = ++res[i - 1]; else if (cur > 0) cur = res[cur]; else res[i++] = 0
     */
    static int[] getPmtArray(char[] str) {
        if (str.length == 1) {
            return new int[] { -1 };
        }
        int[] pmt = new int[str.length];
        pmt[0] = -1;
        int pos = 2, cnd = 0;
        while (pos < str.length) {
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
        System.out.println(getIndexOf("vscode insiders", "o")); // 3
        System.out.println(getIndexOf("ABAABACABABCopq", "ABACABABC")); // 3
        System.out.println(getIndexOf("abcdabcd8bcd", "abcd8bcd")); // 4
        // System.out.println(Arrays.toString(getNextArray("abababca".toCharArray())));
        // // [-1, 0, 0, 1, 2, 3, 4, 0]
        // System.out.println(Arrays.toString(getNextArray("abcd8bcd".toCharArray())));
        // // [-1, 0, 0, 0, 0, 0, 0, 0]
        // System.out.println(Arrays.toString(getNextArray("ABCDABD".toCharArray())));
        // // [-1, 0, 0, 0, 0, 1, 2]
        // System.out.println(Arrays.toString(getNextArray("ABACABABC".toCharArray())));
        // // [-1, 0, 0, 1, 0, 1, 2, 3, 2]
    }
}