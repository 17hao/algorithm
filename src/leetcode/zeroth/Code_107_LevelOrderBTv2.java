package leetcode.zeroth;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 二叉树的层次遍历(自底向上)
 *
 * @since 2019-12-7 Saturday
 */
public class Code_107_LevelOrderBTv2 {
    List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    void helper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() == level) result.add(new ArrayList<>());
        List<Integer> l = result.get(level);
        l.add(root.val);
        helper(root.left, level + 1, result);
        helper(root.right, level + 1, result);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);
        System.out.println(new Code_107_LevelOrderBTv2().levelOrderBottom(root));
    }
}
