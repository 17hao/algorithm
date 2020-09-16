#include <vector>

#include "../List.h"

using std::vector;

/**
 * Add two numbers
 *
 * @since 2020-9-12 Saturday 21:59
 */
class Solution {
   public:
    static ListNode *addTwoNumbers(ListNode *h1, ListNode *h2) {
        ListNode *dummy = new ListNode{-1};
        ListNode *cur = dummy;
        int carry = 0;
        while (h1 != nullptr && h2 != nullptr) {
            int sum = h1->val + h2->val + carry;
            carry = sum >= 10 ? 1 : 0;
            int value = sum % 10;
            ListNode *tmp = new ListNode{value};
            cur->next = tmp;
            cur = tmp;
            h1 = h1->next;
            h2 = h2->next;
        }
        if (carry > 0) {
            while (h1 != nullptr) {
                int sum = h1->val + carry;
                carry = sum >= 10 ? 1 : 0;
                int value = sum % 10;
                ListNode *tmp = new ListNode{value};
                cur->next = tmp;
                cur = tmp;
                h1 = h1->next;
            }
            while (h2 != nullptr) {
                int sum = h2->val + carry;
                carry = sum >= 10 ? 1 : 0;
                int value = sum % 10;
                ListNode *tmp = new ListNode{value};
                cur->next = tmp;
                cur = tmp;
                h2 = h2->next;
            }
        } else {
            cur->next = h1 == nullptr ? h2 : h1;
        }
        if (carry > 0) {
            cur->next = new ListNode{1};
            ;
        }
        return dummy->next;
    }
};

int main() {
    vector<int> v1 = {1};
    vector<int> v2 = {9, 9, 9};
    ListNode *h1 = List::linkedList(v1);
    ListNode *h2 = List::linkedList(v2);
    ListNode *head = Solution::addTwoNumbers(h1, h2);
    List::printList(head);
}