package leetcode.first;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的最大宽度
 *
 * @since 2020-3-9 22:41
 */
public class Code_662_MaxWidthOfBT {
    private int result;

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root, new ArrayList<>(), 1, 1);
        return result;
    }

    private void dfs(TreeNode r, List<Integer> left, int level, int index) {
        if (r == null) return;
        if (level > left.size()) left.add(index);
        result = Math.max(result, index - left.get(level - 1) + 1);
        dfs(r.left, left, level + 1, index * 2);
        dfs(r.right, left, level + 1, index * 2 + 1);
    }
}
