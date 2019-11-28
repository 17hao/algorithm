package leetcode.onece;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Code_020_ValidBrackets {
    static boolean isValid(String s) {
        if (s.length() == 0) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.empty() && map.containsKey(s.charAt(i))) {
                return false;
            }  else if (map.containsValue(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else if (map.get(s.charAt(i)) == stack.peek()) {
                stack.pop();
            } else if ((!stack.empty() && map.containsKey(s.charAt(i)))) {
                stack.push(s.charAt(i));
            }
        }
        return stack.size() <= 0;
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "{}{({()}){}[{()[]}]}";
        String s3 = "";
        String s4 = "(]";
        String s5 = "(";
        String s6 = "]";
        String s7 = "()[";
        String s8 = "()]";
        String s9 = "(])";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));
        System.out.println(isValid(s7));
        System.out.println(isValid(s8));
        System.out.println(isValid(s9));
    }
}
