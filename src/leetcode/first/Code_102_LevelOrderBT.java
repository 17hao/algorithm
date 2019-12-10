package leetcode.first;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历(BFS)
 *
 * @since 2019-12-6 Friday
 */
public class Code_102_LevelOrderBT {
    List<List<Integer>> result = new ArrayList<>();

    List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return result;
    }

    void helper(TreeNode root, int level) {
        if (root == null) return;
        if (result.size() == level) result.add(new ArrayList<>());
        List<Integer> l = result.get(level++);
        l.add(root.val);
        helper(root.left, level);
        helper(root.right, level);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(4);
        root.right = new TreeNode(10);
        root.right.right = new TreeNode(11);
        root.right.left = new TreeNode(7);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(root));
    }
}
