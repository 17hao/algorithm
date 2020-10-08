#include <vector>

#include "../List.h"
#include "../Tree.h"

/**
 * 将有序链表转为二叉搜索树
 *
 * @since 2020-10-8 Thursday 17:40 - 18:34
 */
class Solution {
   public:
    TreeNode* sortedListToBST(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        if (head->next == nullptr) {
            return new TreeNode(head->val);
        }
        ListNode* pre = new ListNode(-1);
        pre->next = head;
        ListNode *fast = head, *slow = head;
        while (fast != nullptr && fast->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
            pre = pre->next;
        }
        pre->next = nullptr;
        TreeNode* root = new TreeNode(slow->val);
        root->right = sortedListToBST(head);
        root->left = sortedListToBST(slow->next);
        return root;
    }
};