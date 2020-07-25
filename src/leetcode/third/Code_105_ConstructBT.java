package leetcode.third;

import leetcode.first.Code_102_LevelOrderBT;
import tool.TreeNode;

/**
 * 从前序遍历和中序遍历中构建二叉树 树中没有重复元素
 * 
 * @since 2020-7-24 Friday 15:32 - 15:54
 */
public class Code_105_ConstructBT {
    static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        if (preorder.length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int rootIndex = findIndex(inorder, preorder[0]);
        int[] leftPre = new int[rootIndex];
        int[] rightPre = new int[preorder.length - 1 - rootIndex];
        int[] leftIn = new int[rootIndex];
        int[] rightIn = new int[preorder.length - 1 - rootIndex];
        System.arraycopy(preorder, 1, leftPre, 0, rootIndex);
        System.arraycopy(preorder, rootIndex + 1, rightPre, 0, preorder.length - 1 - rootIndex);
        System.arraycopy(inorder, 0, leftIn, 0, rootIndex);
        System.arraycopy(inorder, rootIndex + 1, rightIn, 0, preorder.length - 1 - rootIndex);
        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);
        return root;
    }

    private static int findIndex(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
        Code_102_LevelOrderBT c = new Code_102_LevelOrderBT();
        System.out.println(c.levelOrder(root));
    }
}