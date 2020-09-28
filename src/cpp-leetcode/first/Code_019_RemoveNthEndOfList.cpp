#include <vector>

#include "../List.h"

/**
 * remove Nth end of list
 *
 * @since 2020-9-28 Monday 10:23 - 10:33
 */
class Solution {
   public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if (head == nullptr) {
            return nullptr;
        }
        int len = 1;
        ListNode* tmp = head;
        while (tmp != nullptr) {
            tmp = tmp->next;
            len++;
        }
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode* pre = dummy;
        for (int i = 0; i < len - n - 1; i++) {
            pre = pre->next;
        }
        ListNode* next = pre->next->next;
        pre->next = next;
        return dummy->next;
    }
};

int main(int argc, char const* argv[]) {
    Solution s;
    std::vector<int> v = {1, 2, 3, 4, 5};
    ListNode* head = List::linkedList(v);
    ListNode* res = s.removeNthFromEnd(head, 5);
    List::printList(res);
}
