package leetcode.first;

/**
 * @author 17hao
 * @date 2019-04-26 11:32
 */
public class Code_125_ValidPalindrome {
    private static boolean isPalindrome(String s) {
        boolean res = false;
        s = s.trim().toLowerCase().replaceAll("[^A-Za-z]+", "");
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) == s.charAt(high)) {
                low += 1;
                high -= 1;
            } else break;
        }
        if (low >= high) res = true;
        return res;
    }

    public static void main(String[] args) {
        String s = "OP";
        boolean res = isPalindrome(s);
        System.out.println(res);
    }
}
