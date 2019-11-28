package leetcode.onece;

/**
 * 将字符串转换成int
 *
 * @since 11-28 Thursday
 */
public class Code_008_MyAtoi {
    static int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0) return 0;
        char flag = '+';
        int index = 0;
        double result = 0;
        if (s.charAt(index) == '-') {
            flag = '-';
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        } else if (s.charAt(index) < '0' || s.charAt(index) > '9') {
            return 0;
        }
        while (index < s.length() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
            result = result * 10 + s.charAt(index) - '0';
            index++;
        }
        if (flag == '-') result = -result;
        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = " ";
        String s3 = "6";
        String s4 = "-6";
        String s5 = "a6";
        String s6 = "6a";
        String s7 = "9999999999999999999999999";
        String s8 = "-9999999999999999999999999";
        String s9 = "006";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
        System.out.println(myAtoi(s6));
        System.out.println(myAtoi(s7));
        System.out.println(myAtoi(s8));
        System.out.println(myAtoi(s9));
      }
}
