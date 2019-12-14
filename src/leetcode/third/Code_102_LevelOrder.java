package leetcode.third;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历
 *
 * @since 2019-12-13 Friday
 */
public class Code_102_LevelOrder {
    List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, 0, result);
        return result;
    }

    private void helper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() == depth) result.add(new ArrayList<>());
        List<Integer> l = result.get(depth);
        l.add(root.val);
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        System.out.println(new Code_102_LevelOrder().levelOrder(root));
    }
}
