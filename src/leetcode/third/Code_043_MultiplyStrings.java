package leetcode.third;

/**
 * 字符串相乘
 *
 * @since 2020-5-28 Thursday 14:30 - 14:50
 */
public class Code_043_MultiplyStrings {
    static String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int m = num1.length() - 1, n = num2.length() - 1;
        String res = "0";
        for (; m >= 0; m--) {
            for (; n >= 0; n--) {
                int tmp = (num1.charAt(m) - '0') * (num2.charAt(n) - '0');
                StringBuilder addNumber = new StringBuilder();
                addNumber.append(tmp);
                for (int i = 0; i < (l1 - 1 - m + l2 - 1 - n); i++) {
                    addNumber.append(0);
                }
                res = add(addNumber.toString(), res);
            }
        }
        return res;
    }

    static private String add(String num1, String num2) {
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
        System.out.println(multiply("1", "0"));
        System.out.println(multiply("999", "0"));
        System.out.println(multiply("12", "21"));
        System.out.println(multiply("22", "55"));
        System.out.println(multiply("2", "456"));
        System.out.println(multiply("123", "456"));
    }
}
