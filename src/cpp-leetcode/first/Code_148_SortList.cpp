#include <vector>

#include "../List.h"

/**
 * sort linked list in O(nlogn) time and O(1) space comple
 * merge sort
 *
 * @since 2020-9-27 Sunday 11:42 - 11:55
 */
class Solution {
   public:
    ListNode* sortList(ListNode* head) {
        if (head == nullptr || head->next == nullptr)
            return head;
        ListNode *f = head, *s = head;
        while (f->next != nullptr && f->next->next != nullptr) {
            f = f->next->next;
            s = s->next;
        }
        ListNode* mid = s->next;
        s->next = nullptr;
        ListNode* l = sortList(head);
        ListNode* r = sortList(mid);
        ListNode *dummy = new ListNode(-1), *cur = dummy;
        while (l != nullptr && r != nullptr) {
            if (l->val < r->val) {
                cur->next = l;
                l = l->next;
            } else {
                cur->next = r;
                r = r->next;
            }
            cur = cur->next;
        }
        if (l != nullptr) {
            cur->next = l;
        }
        if (r != nullptr) {
            cur->next = r;
        }
        return dummy->next;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    std::vector<int> v = {3, 14, -1, 12, 0, 1};
    ListNode* h = List::linkedList(v);
    ListNode* res = s.sortList(h);
    List::printList(res);
}
