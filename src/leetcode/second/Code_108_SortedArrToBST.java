package leetcode.second;

import tool.TreeNode;

/**
 * 将有序数组转为高度平衡二叉搜索树(左右两个子树的高度差的绝对值不超过1)
 *
 * @since 2019-12-14 Saturday
 */
public class Code_108_SortedArrToBST {
    TreeNode sortedArrToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return  null;
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] n1 = {1, 2, 3, 4, 5};
        int[] n2 = {-10, -3, 0, 5, 9};
        TreeNode root1 = new Code_108_SortedArrToBST().sortedArrToBST(n1);
        TreeNode root2 = new Code_108_SortedArrToBST().sortedArrToBST(n2);
        System.out.println(new Code_102_LevelOrderBT().levelOrder(root1));
        System.out.println(new Code_102_LevelOrderBT().levelOrder(root2));
    }
}
