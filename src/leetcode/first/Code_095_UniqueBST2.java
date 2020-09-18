package leetcode.first;

import java.util.ArrayList;
import java.util.List;

import leetcode.tool.TreeNode;

/**
 * 不同的二叉搜索树2
 * 
 * @since 2020-7-6 Monday 16:51
 */
public class Code_095_UniqueBST2 {
    static List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return getAns(1, n);
    }

    static List<TreeNode> getAns(int start, int end) {
        List<TreeNode> ans = new ArrayList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        if (start == end) {
            ans.add(new TreeNode(start));
            return ans;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = getAns(start, i - 1);
            List<TreeNode> right = getAns(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<TreeNode> ans = generateTrees(3);
        Code_102_LevelOrderBT c = new Code_102_LevelOrderBT();
        for (TreeNode r : ans) {
            System.out.println(c.levelOrder(r));
        }
    }
}