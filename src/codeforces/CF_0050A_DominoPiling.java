package codeforces;

import java.util.Scanner;

/**
 * @since 2021-2-18 Thursday 17:44 - 17:50
 */
public class CF_0050A_DominoPiling {
    static void solution(int m, int n) {
        int x = m / 2;
        int res = x * n + (m % 2) * n / 2;
        System.out.println(res);
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.next());
        int n = Integer.parseInt(scanner.next());
        solution(m, n);
    }
}
