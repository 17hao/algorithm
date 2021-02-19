package codeforces;

import java.util.Scanner;

/**
 * @since 2021-2-19 Friday 21:21
 */
public class CF_0282A_Bit {
    static void solution(String[] statements) {
        int res = 0;
        for (String stmt : statements) {
            if (stmt.contains("++")) {
                res++;
            }
            if (stmt.contains("--")) {
                res--;
            }
        }
        System.out.println(res);
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int lines = scanner.nextInt();
        String[] statements = new String[lines];
        for (int i = 0; i < lines; i++) {
            statements[i] = scanner.next();
        }
        solution(statements);
    }
}
