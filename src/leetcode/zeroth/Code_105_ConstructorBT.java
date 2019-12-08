package leetcode.zeroth;

import tool.TreeNode;

import java.util.HashMap;

/**
 * 从前序遍历和中序遍历中构建二叉树
 *
 * @since 2019-12-8
 */
public class Code_105_ConstructorBT {
    TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
        return helperV2(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) return null;
        int rootVal = preorder[pStart];
        int iRootIndex = 0;
        for (int i = iStart; i < iEnd; i++) {
            if (inorder[i] == rootVal) {
                iRootIndex = i;
                break;
            }
        }
        int leftTreeSize = iRootIndex - iStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, pStart + 1, pStart + 1 + leftTreeSize, inorder, iStart, iStart + leftTreeSize);
        root.right = helper(preorder, pStart + 1 + leftTreeSize, pEnd, inorder, iStart + leftTreeSize + 1, iEnd);
        return root;
    }

    TreeNode helperV2(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd, HashMap<Integer, Integer> map) {
        if (pStart == pEnd) return null;
        int rootVal = preorder[pStart];
        int iRootIndex = map.get(rootVal);
        int leftTreeSize = iRootIndex - iStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helperV2(preorder, pStart + 1, pStart + 1 + leftTreeSize, inorder, iStart, iStart + leftTreeSize, map);
        root.right = helperV2(preorder, pStart + 1 + leftTreeSize, pEnd, inorder, iStart + 1 + leftTreeSize, iEnd, map);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = new Code_105_ConstructorBT().buildTree(preorder, inorder);
        System.out.println(root.left.val + " " + root.right.val);
    }
}
