#include <iostream>
#include <vector>

#include "../List.h"

/**
 * intersection of linked-list
 *
 * @since 2020-9-16 Wednesday 15:44
 */
class Solution {
   public:
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        if (headA == nullptr || headB == nullptr) {
            return nullptr;
        }
        ListNode *l1 = headA, *l2 = headB;
        while (l1 != l2) {
            l1 = l1 == nullptr ? headB : l1->next;
            l2 = l2 == nullptr ? headA : l2->next;
        }
        return l1;
    }
};

int main(int argc, char const *argv[]) {
    Solution s;
    std::vector<int> v = {1, 2, 3, 4};
    ListNode *headA = List::linkedList(v);
    ListNode *headB = new ListNode(9);
    headB->next = headA->next->next;
    ListNode *res = s.getIntersectionNode(headA, headB);
    if (res == NULL) {
        std::cout << "no intersection\n";
        exit(-1);
    }
    std::cout << res->val << std::endl;
}
