package leetcode.first;

import tool.TreeNode;

/**
 * 将一个升序数组转换为一棵高度平衡二叉搜索树。
 * 高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1
 *
 * @since 2019-12-10 Tuesday
 */
public class Code_108_SortedArrayToBST {
    TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }

    TreeNode helper(int[] nums, int start, int end) {
        if (start == end) return null;
        int mid = (start + end) >>> 1;
        int rootValue = nums[mid];
        TreeNode root = new TreeNode(rootValue);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] num = {-10, -3, 0, 5, 9};
        TreeNode result = new Code_108_SortedArrayToBST().sortedArrayToBST(num);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(result));
    }
}
