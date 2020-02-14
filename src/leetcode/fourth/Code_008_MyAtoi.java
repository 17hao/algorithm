package leetcode.fourth;

/**
 * atoi
 * ① 去除头尾空格
 * ② 判断正负和合法性
 * ③ 用double存储结果
 * ④ 加上正负
 * ⑤ 判断溢出
 * @since 2020-2-14 9:54
 */
public class Code_008_MyAtoi {
    static int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        char flag = '+';
        int index = 0;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            flag = '-';
            index++;
        } else if (str.charAt(index) < '0' || str.charAt(index) > '9') {
            return 0;
        }
        double result = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            result = result * 10 + (str.charAt(index) - '0');
            index++;
        }
        if (flag == '-') {
            result = -result;
        }
        if (result > Integer.MAX_VALUE) {
            result = Integer.MAX_VALUE;
        } else if (result < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
        System.out.println(myAtoi("+42"));
        System.out.println(myAtoi("      -42"));
        System.out.println(myAtoi("-42"));
        System.out.println(myAtoi("42 with words"));
        System.out.println(myAtoi("words with 42"));
        System.out.println(myAtoi("0000000000012345678"));
        System.out.println(myAtoi("2147483647"));
        System.out.println(myAtoi("-2147483648"));
        System.out.println(myAtoi("-91283472332"));
    }
}
