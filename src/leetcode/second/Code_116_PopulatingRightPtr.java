package leetcode.second;

import tool.Node;

/**
 * 填充每个节点的右侧指针
 *
 * @since 2019-12-31 Tuesday 14:08
 */
public class Code_116_PopulatingRightPtr {
    Node connect(Node root) {
        if (root == null) {
            return null;
        } else if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}
