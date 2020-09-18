package leetcode.first;

import leetcode.tool.TreeNode;

import java.util.HashMap;

/**
 * 从后序中序遍历中构建二叉树(假设没重复元素)
 *
 * @since 2019-12-11 Wednesday
 */
public class Code_106_ConstructBT {
    TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }

    TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, HashMap<Integer, Integer> map) {
        if (pStart == pEnd) return null;
        int rootValue = postorder[pEnd - 1];
        int inorderRootValueIndex = map.get(rootValue);
        int leftTreeSize = inorderRootValueIndex - iStart;
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(inorder, iStart, iStart + leftTreeSize, postorder, pStart, pStart + leftTreeSize, map);
        root.right = helper(inorder, iStart + leftTreeSize + 1, iEnd, postorder, pStart + leftTreeSize, pEnd - 1, map);
        return root;
    }

    public static void main(String[] args) {
        int[] i = {9, 3, 15, 20, 7};
        int[] j = {9, 15, 7, 20, 3};
        TreeNode result = new Code_106_ConstructBT().buildTree(i, j);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(result));
    }
}
