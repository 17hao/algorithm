package epoch;

import leetcode.tool.TreeNode;

/**
 * 二叉搜索树的最小绝对差
 * 所有节点为非负值的二叉搜索树，计算树中任意两节点差的绝对值的最小值
 * <p>
 * 因为是二叉搜索树，所以中序遍历返回了节点值从小到大的排序，两节点差的绝对值的最小值在升序数组相邻的两个数产生。
 * 记录最小值和前一个节点，在中序遍历的过程中，如果前节点不为空，计算当前节点和前节点的差的绝对值并且和已有的最小值做比较；
 * 比较完成后将前节点赋值为当前节点。
 *
 * @since 2021-4-14  Wednesday 21:25
 */
public class Problem0530 {
    private int res = Integer.MAX_VALUE;
    private TreeNode pre;

    public static void main(String... args) {
        TreeNode root = TreeNode.binarySearchTree();
        //inOrderTraversal(root);
        Problem0530 p = new Problem0530();
        int res = p.getMinimumDifference(root);
        System.out.println(res);
    }

    static void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.val);
        inOrderTraversal(root.right);
    }

    int getMinimumDifference(TreeNode root) {
        getMin(root);
        return res;
    }

    private void getMin(TreeNode root) {
        if (root == null) {
            return;
        }
        getMin(root.left);
        if (pre != null) {
            res = Math.min(res, Math.abs(pre.val - root.val));
        }
        pre = root;
        getMin(root.right);
    }
}
