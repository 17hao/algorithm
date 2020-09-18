#include <vector>

#include "../List.h"

/**
 * reverse the nodes of a linked list k at a time
 *
 * @since 2020-9-18 Friday 11:37 - 11:51
 */
class Solution {
   private:
    ListNode* reverse(ListNode* head) {
        ListNode* dummy = new ListNode(-1);
        while (head != nullptr) {
            ListNode* next = dummy->next;
            ListNode* nextH = head->next;
            dummy->next = head;
            head->next = next;
            head = nextH;
        }
        return dummy->next;
    }

   public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* dummy = new ListNode(-1);
        dummy->next = head;
        ListNode *pre = dummy, *next, *start = pre->next, *end = dummy;
        while (true) {
            for (int i = 0; i < k && end != nullptr; i++) {
                end = end->next;
                if (end == nullptr)
                    return dummy->next;
            }
            next = end->next;
            end->next = nullptr;
            ListNode* node = reverse(start);
            pre->next = node;
            start->next = next;
            pre = start;
            end = pre;
            start = pre->next;
        }
        return dummy->next;
    }
};

int main(int argc, char const* argv[]) {
    // std::vector<int> v = {1, 2, 3, 4, 5};
    std::vector<int> v = {};
    Solution s;
    List::printList(s.reverseKGroup(List::linkedList(v), 3));
    List::printList(s.reverseKGroup(List::linkedList(v), 2));
}
