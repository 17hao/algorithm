package leetcode.fourth;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import leetcode.tool.TreeNode;

/**
 * 二叉树的中序遍历
 * 迭代
 * 
 * @since 2020-8-4 Tuesday 9:37 - 10:01
 */
public class Code_094_InorderTraversal {
    static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            root = root.left;
            while (!stack.isEmpty()) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                res.add(root.val);
                root = root.right;
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        return res;
    }

    static List<Integer> _inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root !=  null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || root != null) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    res.add(root.val);
                    root = root.right;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(inorderTraversal(TreeNode.tree()));
        System.out.println(_inorderTraversal(TreeNode.tree()));
    }
}