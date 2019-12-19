package leetcode.second;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * @since 2019-12-19 Thursday
 */
public class Code_415_AddStrings {
    static String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                int sum = num2.charAt(j--) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            } else if (j < 0) {
                int sum = num1.charAt(i--) - '0' + carry;
                sb.append(sum % 10);
                carry = sum / 10;
            } else {
                int sum = num1.charAt(i--) - '0' + num2.charAt(j--) - '0' + carry;
                carry = sum / 10;
                sb.append(sum % 10);
            }
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    static String addStringsUpdate(String num1, String num2) {
        int l1 = num1.length() - 1, l2 = num2.length() - 1, carry = 0;
        StringBuilder sb = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1--) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2--) - '0' : 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("0", "1"));
        System.out.println(addStrings("1", "99"));
        System.out.println(addStrings("3", "3"));
        System.out.println(addStrings("9", "3"));
        System.out.println(addStrings("10", "25"));
        System.out.println(addStrings("299", "1"));
        System.out.println("== separator ==");
        System.out.println(addStringsUpdate("0", "1"));
        System.out.println(addStringsUpdate("1", "99"));
        System.out.println(addStringsUpdate("3", "3"));
        System.out.println(addStringsUpdate("9", "3"));
        System.out.println(addStringsUpdate("10", "25"));
        System.out.println(addStringsUpdate("299", "1"));
    }
}
