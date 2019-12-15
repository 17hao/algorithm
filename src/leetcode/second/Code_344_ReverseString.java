package leetcode.second;

/**
 * 原地反转字符串
 *
 * @since 2019-12-15 Sunday
 */
public class Code_344_ReverseString {
    static void reverseString(char[] s) {
        if (s.length == 0) return;
        int l = 0, r = s.length - 1;
        for (; l <= (s.length - 1 >>> 1); l++) {
            char temp = s[r];
            s[r--] = s[l];
            s[l]  = temp;
        }
    }

    public static void main(String[] args) {
        char[] c1 = {'h', 'e', 'l', 'l', 'o'};
        char[] c2 = {};
        reverseString(c1);
        reverseString(c2);
        System.out.println(c1);
        System.out.println(c2);
    }
}
