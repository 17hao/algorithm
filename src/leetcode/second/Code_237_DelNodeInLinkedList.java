package leetcode.second;

import tool.ListNode;

/**
 * 删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * i.e.
 * - 链表至少包含两个节点。
 * - 链表中所有节点的值都是唯一的。
 * - 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
 * - 不要从你的函数中返回任何结果。
 *
 * @since 2019-12-14 Saturday
 */
public class Code_237_DelNodeInLinkedList {
    void deleteNode(ListNode node) {
        ListNode temp = node.next.next;
        node.val = node.next.val;
        node.next = temp;
    }
}
