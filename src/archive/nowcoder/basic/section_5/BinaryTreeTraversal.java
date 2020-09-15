package nowcoder.basic.section_5;

import tool.TreeNode;

public class BinaryTreeTraversal {
    void preOrderRecur(TreeNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    void inOrderRecur(TreeNode head) {
        if (head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.val + " ");
        inOrderRecur(head.right);
    }

    void posOrderRecur(TreeNode head) {
        if (head == null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.val + " ");
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        BinaryTreeTraversal bt = new BinaryTreeTraversal();
        System.out.println("\n===pre order===");
        bt.preOrderRecur(head);
        System.out.println("\n===in order===");
        bt.inOrderRecur(head);
        System.out.println("\n===pos order===");
        bt.posOrderRecur(head);
    }
}
