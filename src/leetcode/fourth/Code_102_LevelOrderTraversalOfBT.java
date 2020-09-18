package leetcode.fourth;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的层次遍历
 * 关键是层数对应结果集中的index
 *
 * @since 2020-2-23 22:11
 */
public class Code_102_LevelOrderTraversalOfBT {
    static public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, 0);
        return result;
    }

    static private void helper(TreeNode root, List<List<Integer>> result, int level) {
        if (root == null) return;
        if (result.size() == level) result.add(new ArrayList<>());
        List<Integer> l = result.get(level);
        l.add(root.val);
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(0);
        System.out.println(levelOrder(root));
    }
}
