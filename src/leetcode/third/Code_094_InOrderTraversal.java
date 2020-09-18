package leetcode.third;

import leetcode.tool.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * @sicne 2019-12-4 Wednesday
 */
public class Code_094_InOrderTraversal {
    static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        return process(root, result);
    }

    static List<Integer> process(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        } else {
            process(root.left, result);
            result.add(root.val);
            process(root.right, result);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(inOrderTraversal(root));
    }
}
