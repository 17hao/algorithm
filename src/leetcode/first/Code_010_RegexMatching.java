package leetcode.first;

/**
 * 实现匹配.和*的正则表达式 
 * . 匹配一个任意字符
 * * 匹配任意数量前一个字符
 * 状态方程定义：dp[i][j]表示s前i个能否和p前j个匹配上
 * 状态方程转移：如果s[i - 1]==p[j - 1] || p[j - 1]=='.' : dp[i][j] = dp[i - 1][j - 1]
 * 如果p[j - 1] = '*':
 * 如果p[j - 2] != s[i - 1]: dp[i][j] = dp[i][j - 2] // a* matches empth string
 * 如果p[j - 2] = s[i - 1] || p[j - 2] = '.': dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j]  
 * 初始化：dp[0][0] = true dp[0][i] = p[i - 1] == '*' ? true : false
 * 结果：dp[i][j]
 *
 * @since 2020-8-17 Monday 22:49
 * @finished 2020-8-18 15:45 - 16:35
 */
public class Code_010_RegexMatching {
	static boolean isMatching(String s, String p) {
		int l1 = s.length(), l2 = p.length();
		boolean[][] dp = new boolean[l1 + 1][l2 + 1];
		dp[0][0] = true;
		for (int i = 2; i <= l2; i+= 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            }
		}
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 2];
					}
				}
			}
		}
		return dp[l1][l2];
	}

	public static void main(String... args) {
		System.out.println(isMatching("aa", "aa*"));
		System.out.println(isMatching("aa", "ab*"));
		System.out.println(isMatching("abc", "a.*"));
		System.out.println(isMatching("abc", "ab.*"));
		System.out.println(isMatching("abc", "a.*c"));
		System.out.println(isMatching("aab", "c*a*b"));
		System.out.println(isMatching("a", ".*..a"));
		System.out.println(isMatching("a", ".*..a*"));
	}
}
