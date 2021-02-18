package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @since 2021-2-18 Thursday 17:53
 */
public class CF_0118A_StringTask {
    static void solution(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        vowels.add('Y');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (vowels.contains(c)) {
                continue;
            }
            if (isUppercase(c)) {
                c = Character.toLowerCase(c);
            }
            if (isLowercase(c)) {
                sb.append('.');
            }
            sb.append(c);
        }
        System.out.println(sb.toString());
    }

    private static boolean isUppercase(char c) {
        return c >= 'A' && c <= 'Z';
    }

    private static boolean isLowercase(char c) {
        return c >= 'a' && c <= 'z';
    }

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        solution(str);
    }
}
