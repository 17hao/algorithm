package leetcode.onece;

import tool.TreeNode;

import java.util.HashMap;

/**
 * 从前序和中序遍历中构建二叉树
 *
 * @since 2019-12-10 Thursday
 */
public class Code_105_ConstructBT {
    TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, preorder.length, map);
    }

    TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> map) {
        if (pStart == pEnd) return null;
        int rootValue = preorder[pStart];
        TreeNode root = new TreeNode(rootValue);
        int rootInorderIndex = map.get(rootValue);
        int leftTreeSize = rootInorderIndex - iStart;
        root.left = helper(preorder, pStart + 1, pStart + 1 + leftTreeSize, inorder, iStart, iStart + leftTreeSize, map);
        root.right = helper(preorder, pStart + 1 + leftTreeSize, pEnd, inorder, iStart + 1 + leftTreeSize, iEnd, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Code_105_ConstructBT().buildTree(preorder, inorder);
        System.out.println(root.left.val + " " + root.right.val);
    }
}
