package leetcode.first;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前序遍历
 *
 * @since 2020-1-12 Sunday
 * @update 2020-3-20 Friday 14:42
 */
public class Code_144_Preorder {
    /**
     * recursive
     */
    static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    private static void helper(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        } else {
            res.add(root.val);
            helper(res, root.left);
            helper(res, root.right);
        }
    }

    /**
     * iterator
     */
    static List<Integer> preOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if (temp != null) {
                result.add(temp.val);
                stack.push(temp.right);
                stack.push(temp.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(preorderTraversal(root));
        System.out.println(preOrderTraversal(root));
    }
}
