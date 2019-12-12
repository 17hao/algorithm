package leetcode.first;

/**
 * 给定两个字符串形式的非负整数num1和num2 ，计算它们的和。
 *
 * @since 2019-12-12 Thursday
 */
public class Code_415_AddStrings {
    static String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2) - '0' : 0;
            int tmp = n1 + n2 + carry;
            result.insert(0, tmp % 10);
            carry = tmp / 10;
            l1--;
            l2--;
        }
        if (carry == 1) result.insert(0, 1);
        return result.toString();
    }

    public static void main(String[] args) {
        // System.out.println(addStrings("1", "2"));
        // System.out.println(addStrings("0", "2"));
        // System.out.println(addStrings("123", "321"));
        // System.out.println(addStrings("1", "123"));
        System.out.println(addStrings("18", "584"));
    }
}
