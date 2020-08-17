package leetcode.first;

/**
 * 实现匹配.和*的正则表达式 
 *
 * @since 2020-8-17 Monday 22:49
 */
public claass Code_010_RegexMatching {
    static isMatching(String s, String p) {
	int l1 = s.length(), l2 = p.length();
	boolean[][] dp = new boolean[l1 + 1][l2 + 1];
	dp[0][0] = true;
	for (int i = 2; i <= l2; i+=2) {
	    if (p.charAt(i - 1) == '*') {
		dp[0][i] = true;
	    }
	}
	for (int i = 1; i <= l1; i++) {
	    for (int j = 1; j <= l2; j++) {
		if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') {
		    dp[i][j] = dp[i - 1][j - 1];
		} else if (p.charAt(j - 1) == '*') {
		    if (s.charAt(i - 1) != p.charAt(j  -2) && p.charAt(j - 2) != '.') {
			dp[i][j] = dp[i][j - 2];
		    } else {
			dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
		    }
		}
	    }
	}
	return dp[l1][l2];
    }

    public static void main(String...args) {
	System.out.println(isMatching("aa", "aa*"));	
	System.out.println(isMatching("aa", "ab*"));
	System.out.println(isMatching("abc", "a.*"));	
	System.out.println(isMatching("abc", "ab.*"));	
	System.out.println(isMatching("abc", "a.*c"));	
	System.out.println(isMatching("aab", "c*a*b"));	
	System.out.println(isMatching("a", ".*..a"));	
    }
}
