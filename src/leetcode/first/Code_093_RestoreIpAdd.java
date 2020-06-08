package leetcode.first;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 *
 * @since 2020-6-8 Monday 19:38
 */
public class Code_093_RestoreIpAdd {
    static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s.length() < 4) return res;
        StringBuilder builder = new StringBuilder();
        for (int a = 1; a < 4; a++) {
            for (int b = 1; b < 4; b++) {
                for (int c = 1; c < 4; c++) {
                    for (int d = 1; d < 4; d++) {
                        if ((a + b + c + d) == s.length()) {
                            int n1 = Integer.parseInt(s.substring(0, a));
                            int n2 = Integer.parseInt(s.substring(a, a + b));
                            int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
                            int n4 = Integer.parseInt(s.substring(a + b + c, a + b + c + d));
                            if (n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255) {
                                builder.append(n1).append(".").append(n2).append(".").append(n3).append(".").append(n4);
                                if (builder.length() == (s.length() + 3)) {
                                    res.add(builder.toString());
                                }
                                builder.delete(0, builder.length());
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("192168111"));
        System.out.println(restoreIpAddresses("1921681111"));
        System.out.println(restoreIpAddresses("010010")); //["0.10.0.10","0.100.1.0"]
    }
}
