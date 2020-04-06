package leetcode.fifth;

/**
 * 字符串转整数
 *
 * @since 2020-4-5 Sunday 21:50 - 22:18
 */
public class Code_008_MyAtoi {
    static int myAtoi(String str) {
        str = str.trim();
        int len = str.length();
        if (len == 0) return 0;
        int flag = 1, index = 0;
        double res = 0;
        if (str.charAt(0) == '-') {
            flag = -1;
            index++;
        } else if (str.charAt(0) == '+') {
            index++;
        } else if (str.charAt(0) < '0' || str.charAt(0) > '9') {
            return (int) res;
        }
        while (index < len) {
            if (str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                res = res * 10 + (str.charAt(index++) - '0');
            } else {
                break;
            }
        }
        if (flag == -1) res = -res;
        if (res > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (res < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi(""));
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("as42"));
        System.out.println(myAtoi("42as"));
        System.out.println(myAtoi("-91283472332"));
    }
}
