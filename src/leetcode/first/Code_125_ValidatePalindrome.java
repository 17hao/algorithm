package leetcode.first;

public class Code_125_ValidatePalindrome {
    static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        boolean result = true;
        for (int i = 0; i < s.length() / 2; i++) {
            if (!(s.charAt(i) == s.charAt(s.length() - i - 1))) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s1));
    }
}
