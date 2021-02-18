package codeforces;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @since 2021-2-18 Thursday 17:17 - 17:40
 */
public class CF_0231A_Team {
    static void solution(int[][] views) {
        int res = 0;
        for (int i = 0; i < views.length; i++) {
            int consensus = 0;
            for (int j = 0; j < 3; j++) {
                consensus += views[i][j];
                if (consensus >= 2) {
                    break;
                }
            }
            if (consensus >= 2) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(br.readLine());
        //System.out.println(lines);
        int[][] views = new int[lines][3];
        for (int i = 0; i < lines; i++) {
            String s = br.readLine();
            //System.out.println(s);
            String[] strings = s.trim().split("\\s+");
            views[i][0] = Integer.parseInt(strings[0]);
            views[i][1] = Integer.parseInt(strings[1]);
            views[i][2] = Integer.parseInt(strings[2]);
        }
        solution(views);
    }
}
