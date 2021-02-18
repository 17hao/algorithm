package codeforces;

import java.util.Scanner;

/**
 * @since 2021-2-18 Thursday 16:00
 */
public class CF_0004A_Watermelon {
    static void solution(int i) {
        if (i <= 2 || i % 2 != 0) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        solution(i);
    }
}
