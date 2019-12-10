package leetcode.third;

/**
 * 整数转换成罗马数字
 *
 * @since 11-29 Friday
 */
public class Code_012_IntToRoman {
    static String intToRoman(int num) {
        int[] integer = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (num > 0) {
            int count = num / integer[index];
            while (count-- > 0) {
                sb.append(roman[index]);
            }
            num %= integer[index++];
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int i1 = 1;
        int i2 = 9;
        int i3 = 10;
        int i4 = 40;
        int i5 = 99;
        int i6 = 3999;
        int i7 = 3210;
        System.out.println(intToRoman(i1));
        System.out.println(intToRoman(i2));
        System.out.println(intToRoman(i3));
        System.out.println(intToRoman(i4));
        System.out.println(intToRoman(i5));
        System.out.println(intToRoman(i6));
        System.out.println(intToRoman(i7));
    }
}
