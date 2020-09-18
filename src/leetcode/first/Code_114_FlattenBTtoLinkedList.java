package leetcode.first;

import leetcode.tool.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * @since 2019-12-25 Wednesday 15:23 - 15:51
 */
public class Code_114_FlattenBTtoLinkedList {
    static void flatten(TreeNode root) {
        if (root == null) {
            return;
        } else {
            TreeNode temp = root.right;
            root.right = root.left;
            TreeNode rightNode = root;
            while (rightNode.right != null) {
                rightNode = rightNode.right;
            }
            rightNode.right= temp;
            root.left = null;
            flatten(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.right.right = new TreeNode(4);
        root.left.right.right.right = new TreeNode(5);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(7);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(root));
        flatten(root);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(root));
    }
}
