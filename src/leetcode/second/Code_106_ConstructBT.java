package leetcode.second;

import leetcode.first.Code_102_LevelOrderBT;
import tool.TreeNode;

/**
 * 从中序遍历和后序遍历构建二叉树
 * 
 * @since 2020-7-25 Saturday 18:41
 */
public class Code_106_ConstructBT {
    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        int rootIndex = find(inorder, postorder[postorder.length - 1]);
        int[] leftIn = new int[rootIndex];
        int[] rightIn = new int[inorder.length - 1 - rootIndex];
        int[] leftPost = new int[rootIndex];
        int[] rightPost = new int[inorder.length - 1 - rootIndex];
        System.arraycopy(inorder, 0, leftIn, 0, rootIndex);
        System.arraycopy(inorder, rootIndex + 1, rightIn, 0, inorder.length - 1 - rootIndex);
        System.arraycopy(postorder, 0, leftPost, 0, rootIndex);
        System.arraycopy(postorder, rootIndex, rightPost, 0, inorder.length - 1 - rootIndex);
        root.left = buildTree(leftIn, leftPost);
        root.right = buildTree(rightIn, rightPost);
        return root;
    }

    private static int find(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
        Code_102_LevelOrderBT c = new Code_102_LevelOrderBT();
        System.out.println(c.levelOrder(root));
    }
}