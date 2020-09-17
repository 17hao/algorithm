#include <vector>

using std::vector;

#include "../List.h"

/**
 * merge k sorted linked-list
 *
 * @since 2020-9-17 Thursday 11:40 - 12:00
 */
class Solution {
   private:
    ListNode* mergeTwoLists(ListNode* h1, ListNode* h2) {
        ListNode *dummy = new ListNode(-1), *cur = dummy;
        while (h1 != nullptr && h2 != nullptr) {
            if (h1->val < h2->val) {
                cur->next = h1;
                h1 = h1->next;
            } else {
                cur->next = h2;
                h2 = h2->next;
            }
            cur = cur->next;
        }
        if (h1 == nullptr) {
            cur->next = h2;
        } else {
            cur->next = h1;
        }
        return dummy->next;
    }

    ListNode* merge(vector<ListNode*> lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode* left = merge(lists, l, mid);
        ListNode* right = merge(lists, mid + 1, r);
        return mergeTwoLists(left, right);
    }

   public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        int size = lists.size();
        if (size == 0) {
            return nullptr;
        }
        return merge(lists, 0, size - 1);
    }
};

int main(int argc, char const* argv[]) {
    vector<int> v1 = {1, 3, 5, 7};
    vector<int> v2 = {2, 5, 8, 9};
    vector<int> v3 = {1, 10};
    ListNode* h1 = List::linkedList(v1);
    ListNode* h2 = List::linkedList(v2);
    ListNode* h3 = List::linkedList(v3);
    Solution s;
    // vector<ListNode*> lists = {h1, h2, h3};
    vector<ListNode*> lists = {};
    ListNode* res = s.mergeKLists(lists);
    List::printList(res);
}
