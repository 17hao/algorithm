package leetcode.first;

/**
 * excel序列表
 *
 * @since 2020-1-11
 */
public class Code_171_ExcelSheetColumnNum {
    static int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - 'A' + 1;
            res = res * 26 + temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber(""));
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("ZY"));
    }
}
