package leetcode.first;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化unix路径
 *
 * @since 2020-1-12 Sunday
 */
public class Code_071_SimplifyPath {
    static String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String s : path.split("/")) {
            if (s.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!s.equals(".") && !s.isEmpty()) {
                stack.push(s);
            }
        }
        String res = "";
        for (String s : stack) {
            res = "/" + s + res;
        }
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath(""));
        System.out.println(simplifyPath("/."));
        System.out.println(simplifyPath("/.."));
        System.out.println(simplifyPath("/../etc//hosts"));
        System.out.println(simplifyPath("../etc//hosts"));
    }
}
