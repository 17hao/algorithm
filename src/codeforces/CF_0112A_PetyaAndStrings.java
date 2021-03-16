package codeforces;

import java.util.Scanner;

/**
 * @since 2021-3-16 Thursday 21:20
 */
public class CF_0112A_PetyaAndStrings {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        System.out.println(compare(s1, s2));
    }

    public static int compare(String s1, String s2) {
        String a = s1.toLowerCase();
        String b = s2.toLowerCase();
        int compare = a.compareTo(b);
        return Integer.compare(compare, 0);
    }
}
