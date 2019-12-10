package leetcode.first;

import tool.TreeNode;

/**
 * 翻转二叉树
 *
 * @since 2019-12-10 Thursday
 */
public class Code_226_InvertBT {
    static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tempLeft = root.left;
        root.left = root.right;
        root.right=  tempLeft;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        TreeNode result = invertTree(root);
        System.out.println(result.left.val + " " + result.right.val);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(result));
        System.out.println(Code_094_InOrderTraversal.inorderTraversal(root));
    }
}
