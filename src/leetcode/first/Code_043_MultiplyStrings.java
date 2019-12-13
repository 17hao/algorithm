package leetcode.first;

/**
 * 两个字符串形式的非负整数相乘
 *
 * @since 2019-12-13 Friday
 */
public class Code_043_MultiplyStrings {
    String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        String result = "0";
        for (int i = l2; i >= 0; i--) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int carry = 0;
            int n1 = num2.charAt(i) - '0';
            for (int j = l1; j >= 0; j--) {
                int n2 = num1.charAt(j) - '0';
                int product = n1 * n2 + carry;
                int t = product % 10;
                carry = product / 10;
                temp.append(t);
            }
            if (carry > 0) temp.append(carry);
            result = addStrings(result, temp.reverse().toString());
        }
        return result.replaceFirst("^0+(?!$)", "");
    }

    String addStrings(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int l1 = s1.length() - 1;
        int l2 = s2.length() - 1;
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? s1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? s2.charAt(l2) - '0' : 0;
            int sum = n1 + n2 + carry;
            int temp = sum % 10;
            result.append(temp);
            carry = sum / 10;
            l1--;
            l2--;
        }
        if (carry == 1) result.append(1);
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Code_043_MultiplyStrings c = new Code_043_MultiplyStrings();
        System.out.println(c.multiply("2", "3"));
        System.out.println(c.multiply("23", "33"));
        System.out.println(c.multiply("3", "33456"));
        System.out.println(c.multiply("0", "33456"));
        System.out.println(c.multiply("1", "33456"));
        System.out.println(c.multiply("10", "33456"));
        System.out.println(c.multiply("6", "9"));
    }
}
