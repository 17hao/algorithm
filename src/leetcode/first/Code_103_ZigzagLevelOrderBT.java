package leetcode.first;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的锯齿层次遍历
 * 先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 *
 * @since 2019-12-8 Sunday
 */
public class Code_103_ZigzagLevelOrderBT {
    List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    void helper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() <= depth) {
            result.add(new ArrayList<>());
        }
        List<Integer> l = result.get(depth);
        if (depth % 2 == 0) l.add(root.val);
        else l.add(0, root.val);
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
    }

    List<List<Integer>> zigzagLevelOrderV2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            List<Integer> temp = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (depth % 2 == 0) {
                    temp.add(root.val);
                } else {
                    temp.add(0, root.val);
                }
                if (root.left != null) queue.add(root.left);
                if (root.right != null) queue.add(root.right);
            }
            result.add(temp);
            depth++;
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.right.right.left = new TreeNode(8);
        System.out.println(new Code_103_ZigzagLevelOrderBT().zigzagLevelOrder(head));
        System.out.println(new Code_103_ZigzagLevelOrderBT().zigzagLevelOrderV2(head));
    }
}
