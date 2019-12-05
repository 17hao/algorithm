package leetcode.twice;

/**
 * @since 2019-12-5 Thursday
 */
public class Code_008_MyAtoi {
    static int myAtoi(String str) {
        char flag = '+';
        str = str.trim();
        if (str.length() == 0) return 0;
        int index = 0;
        double result = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            index++;
        }
        if (str.charAt(0) == '+') {
            index++;
        }
        while (index < str.length()) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                result = result * 10 + Character.getNumericValue(str.charAt(index++));
            } else {
                break;
            }
        }
        if (flag == '-') result = -result;
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        String s1 = "";
        String s2 = " ";
        String s3 = "-42";
        String s4 = "42";
        String s5 = "x42";
        String s6 = "42 ";
        String s7 = "42x";
        String s8 = "1000000000000000000000";
        String s9 = "-1000000000000000000000";
        String s10 = "+42";
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
    }
}
