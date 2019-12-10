package leetcode.first;

/**
 * @author 17hao
 * @date 2019-05-02 09:49
 */
public class Code_557_ReverseWordsInString {
    private static String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder res = new StringBuilder();
        for (String string : strings) {
            StringBuilder temp = new StringBuilder();
            for (int i = string.length() - 1; i >= 0; i--) {
                temp.append(string.charAt(i));
            }
            temp.append(" ");
            res.append(temp);
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        String res = reverseWords(s);
        System.out.println(res);
    }
}
