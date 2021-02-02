package leetcode.first;

import java.util.Stack;

/**
 * 字符串解码
 * 
 * @since 2020-2-2 Tuesday 19:15 - 19:54
 */
public class Code_394_DecodeString {
    public String decodeString(String s) {
        Stack<Integer> numbers = new Stack<>();
        Stack<String> strings = new Stack<>();
        int num = 0;
        String res = "";
        String cur = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = 10 * num + (c - '0');
            } else if (c == '[') {
                numbers.push(num);
                strings.push(cur);
                num = 0;
                cur = "";
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                cur += c;
            } else {
                int n = numbers.pop();
                String str = strings.pop();
                for (int j = 0; j < n; j++) {
                    str += cur;
                }
                cur = str;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Code_394_DecodeString c = new Code_394_DecodeString();
        System.out.println(c.decodeString("3[a]2[bc]"));
        System.out.println(c.decodeString("3[a2[c]]"));
        System.out.println(c.decodeString("2[abc]3[cd]ef"));
    }
}