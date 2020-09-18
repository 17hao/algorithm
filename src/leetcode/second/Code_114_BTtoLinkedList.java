package leetcode.second;

import leetcode.tool.TreeNode;

/**
 * 二叉树转链表
 *
 * @since 2019-12-26 Thursday 15:03 - 15:08
 */
public class Code_114_BTtoLinkedList {
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
            rightNode.right = temp;
            root.left = null;
            flatten(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        root.right.left = new TreeNode(3);
        flatten(root);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(root));
    }
}
