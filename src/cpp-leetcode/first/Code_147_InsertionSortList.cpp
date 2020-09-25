#include <vector>

#include "../List.h"

/**
 * sort a linked list using insertion sort
 *
 * @since 2020-9-25 Friday 16:19 - 16:35
 */
class Solution {
   public:
    ListNode* insertionSortList(ListNode* head) {
        if (head == nullptr) {
            return nullptr;
        }
        ListNode* dummy = new ListNode(-1);
        dummy->next = new ListNode(head->val);
        ListNode* cur = head->next;
        while (cur != nullptr) {
            ListNode* h = dummy->next;
            ListNode* nextCur = cur->next;
            if (cur->val < h->val) {
                dummy->next = cur;
                cur->next = h;
            } else {
                while (h->next != nullptr && h->next->val < cur->val) {
                    h = h->next;
                }
                ListNode* nextH = h->next;
                h->next = cur;
                cur->next = nextH;
            }
            cur = nextCur;
            List::printList(dummy->next);
        }
        return dummy->next;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    std::vector<int> v = {3, 1, 5, 6, 9, 9, 10};
    ListNode* head = List::linkedList(v);
    ListNode* res = s.insertionSortList(head);
    List::printList(res);
}
