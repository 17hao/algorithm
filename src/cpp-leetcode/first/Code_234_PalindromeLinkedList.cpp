#include <iostream>
#include <vector>
#include "../List.h"

/**
 * palindrome linked list
 *
 * @since 2020-12-24 Thursday 10:40
 */
class Solution {
public:
    bool isPalindrome(ListNode* head) {
        if (head == nullptr || head->next == nullptr) {
            return true;
        }
        ListNode* slow = head;
        ListNode* fast = head;
        ListNode* cur = nullptr;
        ListNode* next = nullptr;
        while (fast != nullptr && fast->next != nullptr) {
            //while (fast->next != nullptr && fast->next->next != nullptr) {
            cur = slow;
            slow = slow->next;
            fast = fast->next->next;
            cur->next = next;
            next = cur;
        }
        ListNode* p1 = cur;
        ListNode* p2 = fast == nullptr ? slow : slow->next;
        //ListNode* p2 = fast->next == nullptr ? slow : slow->next;
        while (p1 != nullptr) {
            if (p1->val != p2->val) {
                return false;
            }
            p1 = p1->next;
            p2 = p2->next;
        }
        return true;
    }
};

int main(void) {
    Solution s;
    std::vector<int> vec {1,2,3,2,1};
    ListNode* head = List::linkedList(vec);
    std::cout << s.isPalindrome(head) << " ";
}
