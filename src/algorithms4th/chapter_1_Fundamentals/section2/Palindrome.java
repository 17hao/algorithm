package algorithms4th.chapter_1_Fundamentals.section2;

import edu.princeton.cs.algs4.StdOut;

public class Palindrome {
    public static void main(String[] args) {
        StdOut.print(isPalindrome("aweewa"));
    }

    public static boolean isPalindrome(String s) {
        int N = s.length();
        for (int i = 0; i < N / 2; i++) {
            if (s.charAt(i) != s.charAt(N - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
