package codeforces;

import java.util.Scanner;

/**
 * @since 2021-2-18 Thursday 16:35 - 16:49
 */
public class CF_0071A_WayTooLongWords {
    static void solution(String s) {
        if (s.length() <= 10) {
            System.out.println(s);
        } else {
            System.out.print(s.charAt(0));
            System.out.print(s.length() - 2);
            System.out.println(s.charAt(s.length() - 1));
        }
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        for (int i = 0; i < lines; i++) {
            String s = scanner.next();
            solution(s);
        }
    }
}
