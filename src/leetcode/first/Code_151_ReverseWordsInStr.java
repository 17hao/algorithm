package leetcode.first;

/**
 * 反转字符串里的单词
 *
 * @since 2020-6-9 Monday 19:06
 */
public class Code_151_ReverseWordsInStr {
    static String reverseWords(String s) {
        String[] strs = s.split(" +");
        StringBuilder builder = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            builder.append(strs[i]).append(" ");
        }
        return builder.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("hello world"));
        System.out.println(reverseWords(""));
    }
}
