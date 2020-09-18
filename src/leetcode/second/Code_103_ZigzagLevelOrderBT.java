package leetcode.second;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的锯齿层次遍历
 * 先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行
 *
 * @since 2019-12-9 Monday
 */
public class Code_103_ZigzagLevelOrderBT {
    List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }

    void helper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) return;
        if (result.size() == depth) result.add(new ArrayList<>());
        List<Integer> l = result.get(depth);
        if (depth % 2 == 0) {
            l.add(root.val);
        } else {
            l.add(0, root.val);
        }
        helper(root.left, depth + 1, result);
        helper(root.right, depth + 1, result);
    }

    List<List<Integer>> zigzagLevelOrderV2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if (depth % 2 == 0) {
                    l.add(temp.val);
                } else {
                    l.add(0, temp.val);
                }
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            result.add(l);
            depth++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(new Code_103_ZigzagLevelOrderBT().zigzagLevelOrder(root));
        System.out.println(new Code_103_ZigzagLevelOrderBT().zigzagLevelOrderV2(root));
    }
}
