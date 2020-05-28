package leetcode.third;

/**
 * 字符串相加
 *
 * @since 2020-5-28 Thursday 13:38 - 13:49
 */
public class Code_415_AddStrings {
    static String addStrings(String num1, String num2) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int m = num1.length() - 1, n = num2.length() - 1;
        while (m >= 0 || n >= 0) {
            int x = 0, y = 0;
            if (m >= 0) {
                x = num1.charAt(m) - '0';
                m--;
            }
            if (n >= 0) {
                y = num2.charAt(n) - '0';
                n--;
            }
            int tmp = x + y + carry;
            carry = tmp > 9 ? 1 : 0;
            sb.append(tmp % 10);
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "2"));
        System.out.println(addStrings("0", "2"));
        System.out.println(addStrings("1", "999"));
    }
}
