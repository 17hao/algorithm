package leetcode.zeroth;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author 17hao
 * @date 2019-04-22 14:43
 */
public class Code_020_ValidParenthesis {
    private static boolean isValid(String s) {
        boolean res = false;
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (int i = 0; i < s.length(); i++) {
            boolean left = map.containsKey(s.charAt(i));
            boolean right = map.containsValue(s.charAt(i));
            if (left || stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (right && map.containsKey(stack.peek()) && s.charAt(i) == map.get(stack.peek())) {
                stack.pop();
            } else if (right && map.containsKey(stack.peek()) && s.charAt(i) != map.get(stack.peek())) {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            res = true;
        return res;
    }

    public static void main(String[] args) {
        String s = "()";
        String s2 = "(])";
        String s3 = ")}";
        boolean res = isValid(s2);
        System.out.println(res);
    }
}
