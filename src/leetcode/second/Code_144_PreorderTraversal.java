package leetcode.second;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import tool.TreeNode;

/**
 * 二叉树的先序遍历
 * 迭代方式
 * 
 * @since 2020-8-4 Tuesday 8:54 - 9:10
 */
public class Code_144_PreorderTraversal {
    static List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            if (root == null) {
                res.add(stack.pop().val);
                continue;
            }
            res.add(stack.pop().val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                if (!stack.isEmpty()) {
                    root = stack.peek();
                } else {
                    root = null;
                }
            }
        }
        return res;
    }

    static List<Integer> _preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                root = stack.pop();
                res.add(root.val);
                if (root.right != null) {
                    stack.push(root.right);
                }
                if (root.left != null) {
                    stack.push(root.left);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(preorderTraversal(TreeNode.tree())); // 1, 2, 4, 5, 3, 6, 7
        System.out.println(_preorderTraversal(TreeNode.tree())); // 1, 2, 4, 5, 3, 6, 7
    }
}