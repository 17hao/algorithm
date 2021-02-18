package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021-2-18 Thursday 16:54
 */
public class CF_0001A_TheatreSquare {
    static void solution(int n, int m, int a) {
        int x = n % a == 0 ? n / a : n / a + 1;
        int y = m % a == 0 ? m / a : m / a + 1;
        long res = (long) x * y;
        System.out.println(res);
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        int a = Integer.parseInt(strings[2]);
        solution(n, m, a);
    }
}
