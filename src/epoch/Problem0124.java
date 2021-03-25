package epoch;

import leetcode.tool.TreeNode;

/**
 * 二叉树中的最大路径和
 *
 * 对于树中的每个结点，递归过程中返回经过该节点能为最大路径值贡献的值。
 * 额外记录最大路径值，初始值为根节点值。最大路径值为已有的最大路径和以当前节点为根节点的树的路径和的较大值。
 *
 * @since 2021-3-25 Thursday 22:54 - 23:25
 */
public class Problem0124 {
    private static int res;

    public static int maxPathSum(TreeNode root) {
        res = root.val;
        dfs(root);
        return res;
    }

    private static int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        res = Math.max(res, root.val + left + right);
        return Math.max(0, Math.max(root.val + left, root.val + right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree();
        System.out.println(maxPathSum(root));
    }
}
