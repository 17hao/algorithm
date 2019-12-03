package leetcode.zeroth;


/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * @since 12-3 Thursday
 */
public class Code_058_LengthOfLastWord {
    static int lengthOfLastWord(String s) {
        String[] t = s.split(" ");
        if (t.length == 0) return 0;
        return t[t.length - 1].length();
    }

    public static void main(String[] args) {
        String s1 = "Hello World";
        String s2 = "";
        String s3 = " ";
        System.out.println(lengthOfLastWord(s1));
        System.out.println(lengthOfLastWord(s2));
        System.out.println(lengthOfLastWord(s3));
    }
}
