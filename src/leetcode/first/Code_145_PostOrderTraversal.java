package leetcode.first;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @since 2019-12-23 Monday
 */
public class Code_145_PostOrderTraversal {
    List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        } else {
            helper(root.left, result);
            helper(root.right, result);
            result.add(root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);
        System.out.println(new Code_145_PostOrderTraversal().postorderTraversal(root));
    }
}
