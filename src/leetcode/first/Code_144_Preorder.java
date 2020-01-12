package leetcode.first;

import tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的前序遍历
 *
 * @since 2020-1-12 Sunday
 */
public class Code_144_Preorder {
    List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    void helper(List<Integer> res, TreeNode root) {
        if (root == null){
            return;
        } else {
            res.add(root.val);
            helper(res, root.left);
            helper(res, root.right);
        }
    }
}
