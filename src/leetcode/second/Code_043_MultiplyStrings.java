package leetcode.second;

/**
 * 字符串数字相乘
 *
 * @since 2019-12-23 Monday
 */
public class Code_043_MultiplyStrings {
    String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        String result = "";
        for (int l2 = num2.length() - 1; l2 >= 0; l2--) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < num2.length() - 1 - l2; i++) {
                temp.append("0");
            }
            int n2 = num2.charAt(l2) - '0';
            int carry = 0;
            for (int l1 = num1.length() - 1; l1 >= 0; l1--) {
                int n1 = num1.charAt(l1) - '0';
                int product = n1 * n2 + carry;
                temp.append(product % 10);
                carry = product / 10;
            }
            if (carry > 0) temp.append(carry);
            result = addStrings(result, temp.reverse().toString());
        }
        return result;
    }

    private String addStrings(String s1, String s2) {
        int l1 = s1.length() - 1, l2 = s2.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? s1.charAt(l1--) - '0' : 0;
            int n2 = l2 >= 0 ? s2.charAt(l2--) - '0' : 0;
            int sum = n1 + n2 + carry;
            builder.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) builder.append(carry);
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code_043_MultiplyStrings().multiply("999", "1"));
        System.out.println(new Code_043_MultiplyStrings().multiply("999", "2"));
        System.out.println(new Code_043_MultiplyStrings().multiply("1", "999"));
        System.out.println(new Code_043_MultiplyStrings().multiply("0", "999"));
        System.out.println(new Code_043_MultiplyStrings().multiply("1", "9"));
        System.out.println(new Code_043_MultiplyStrings().multiply("2", "99"));
    }
}
