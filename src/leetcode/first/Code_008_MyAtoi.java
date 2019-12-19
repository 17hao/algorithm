package leetcode.first;

/**
 * 将字符串转换成int
 *
 * @since 2019-11-27 Wednesday
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
            result = result * 10 + (s.charAt(index) - '0');
            index++;
        }

        result = (flag == '-' ? -result : result);
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int) result;
        }
    }

    public static void main(String[] args) {
        String s1 = "42";
        String s2 = "str 42";
        String s3 = "-42";
        String s4 = "42 str";
        String s5 = "042";
        String s6 = "-999999999999999999999";
        String s7 = "";
        String s8 = " ";
        String s9 = "9223372036854775808";
        String s10 = "-2147483648";
        String s11 = "2147483647";
        System.out.println(myAtoi(s1));
        System.out.println(myAtoi(s2));
        System.out.println(myAtoi(s3));
        System.out.println(myAtoi(s4));
        System.out.println(myAtoi(s5));
        System.out.println(myAtoi(s6));
        System.out.println(myAtoi(s7));
        System.out.println(myAtoi(s8));
        System.out.println(myAtoi(s9));
        System.out.println(myAtoi(s10));
        System.out.println(myAtoi(s11));
    }
}
