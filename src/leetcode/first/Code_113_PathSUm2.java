package leetcode.first;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 路径总和2
 *
 * @since 2020-5-24 Sunday 19:59 - 21:00
 */
public class Code_113_PathSUm2 {
    static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, sum, res, new ArrayList<>());
        return res;
    }

    static void dfs(TreeNode node, int sum, List<List<Integer>> res, List<Integer> tmp) {
        List<Integer> list = new ArrayList<>(tmp);
        if (node == null) {
            return;
        } else if (node.left == null && node.right == null && (sum - node.val == 0)) {
            list.add(node.val);
            res.add(list);
            return;
        }
        list.add(node.val);
        dfs(node.left, sum - node.val, res, list);
        dfs(node.right, sum - node.val, res, list);

//        if (node == null && sum == 0 && !res.contains(tmp)) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//        if (node == null) {
//            return;
//        }
//        List<Integer> list = new ArrayList<>(tmp);
//        if ((sum - node.val) != 0) {
//            list.add(node.val);
//            if (node.left != null && node.right == null) {
//                dfs(node.left, sum - node.val, res, list);
//            } else if (node.right != null && node.left == null) {
//                dfs(node.right, sum - node.val, res, list);
//            } else {
//                dfs(node.left, sum - node.val, res, list);
//                dfs(node.right, sum - node.val, res, list);
//            }
//        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(pathSum(root, 22));
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
//        System.out.println(pathSum(root, 1));
    }
}
