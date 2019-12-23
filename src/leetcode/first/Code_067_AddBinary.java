package leetcode.first;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * @since 2019-12-23 Monday
 */
public class Code_067_AddBinary {
    static String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder temp = new StringBuilder();
        int l1 = a.length() - 1, l2 = b.length() - 1;
        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 < 0 ? 0 : a.charAt(l1--) - '0';
            int n2 = l2 < 0 ? 0 : b.charAt(l2--) - '0';
            int sum = n1 + n2 + carry;
            temp.append(sum % 2);
            carry = sum / 2;
        }
        if (carry == 1) temp.append("1");
        return temp.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("10", "1"));
        System.out.println(addBinary("101", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
