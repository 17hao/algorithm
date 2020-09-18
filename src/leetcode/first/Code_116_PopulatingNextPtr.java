package leetcode.first;

import leetcode.tool.Node;

/**
 * 给定一个完美二叉树，填充它的每个 next 指针，
 * 让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * @since 2019-12-29 Sunday
 */
public class Code_116_PopulatingNextPtr {
    Node connect(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
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
