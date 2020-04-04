package leetcode.fifth;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历
 *
 * @since 2020-4-4 Saturday 12:06 - 12:13
 */
public class Code_102_BTLevelOrderTraversal {
    static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    private static void helper(List<List<Integer>> res, TreeNode node, int level) {
        if (node == null) return;
        if (res.size() == level) res.add(new ArrayList<>());
        List<Integer> temp = res.get(level);
        temp.add(node.val);
        helper(res, node.left, level + 1);
        helper(res, node.right, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.left.left = new TreeNode(-1);
        System.out.println(levelOrder(root));
    }
}
