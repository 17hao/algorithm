#include <iostream>
#include <vector>

#include "../List.h"

/**
 * reorder linked-list
 *
 * @since 2020-9-16 Wednesday 21:55 - 22:13
 */
class Solution {
   public:
    void reorderList(ListNode* head) {
        if (head == nullptr)
            return;
        ListNode *fast = head, *slow = head;
        while (fast->next != nullptr && fast->next->next != nullptr) {
            fast = fast->next->next;
            slow = slow->next;
        }
        ListNode* tmpHalf = slow->next;
        slow->next = nullptr;
        ListNode* dummy = new ListNode(-1);
        while (tmpHalf != nullptr) {
            ListNode* next1 = dummy->next;
            ListNode* next2 = tmpHalf->next;
            dummy->next = tmpHalf;
            tmpHalf->next = next1;
            tmpHalf = next2;
        }
        ListNode* half = dummy->next;
        ListNode* cur = head;
        while (half != nullptr) {
            ListNode* next = cur->next;
            ListNode* nextHalf = half->next;
            cur->next = half;
            half->next = next;
            cur = next;
            half = nextHalf;
        }
    }
};

int main(int argc, const char* argv[]) {
    std::vector<int> v = {1, 2, 3, 4, 5};
    // std::vector<int> v = {1,2,3,4,5,6};
    ListNode* head = List::linkedList(v);
    Solution s;
    s.reorderList(head);
    List::printList(head);
}