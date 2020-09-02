/* merge k sorted linked list

@since 2020-9-2 Wednesday 16:39 - 17:11
 */

#include "../ListNode.c"

struct ListNode *mergeHelper(struct ListNode **lists, int l, int r);

struct ListNode *mergeTwoLists(struct ListNode *h1, struct ListNode *h2);

struct ListNode *mergeKLists(struct ListNode **lists, int listsSize)
{
    if (lists == 0 || listsSize == 0)
        return 0;
    return mergeHelper(lists, 0, listsSize - 1);
}

struct ListNode *mergeHelper(struct ListNode **lists, int l, int r)
{
    if (l == r)
        return lists[l];
    int mid = l + (r - l) / 2;
    struct ListNode *left = mergeHelper(lists, l, mid);
    struct ListNode *right = mergeHelper(lists, mid + 1, r);
    return mergeTwoLists(left, right);
}

struct ListNode *mergeTwoLists(struct ListNode *h1, struct ListNode *h2)
{
    struct ListNode *dummy = malloc(sizeof(struct ListNode));
    dummy->val = 0;
    dummy->next = 0;
    struct ListNode *pre = dummy;
    while (h1 != 0 && h2 != 0)
    {
        if (h1->val < h2->val)
        {
            pre->next = h1;
            h1 = h1->next;
        }
        else
        {
            pre->next = h2;
            h2 = h2->next;
        }
        pre = pre->next;
    }
    if (h1 != 0)
        pre->next = h1;
    if (h2 != 0)
        pre->next = h2;
    return dummy->next;
}

int main(int argc, char const *argv[])
{
    int a[4] = {1, 3, 5, 7};
    int b[4] = {2, 4, 6, 8};
    ListNode *h1 = linkedlist(a, 4);
    ListNode *h2 = linkedlist(b, 4);
    struct ListNode *lists[2] = {h1, h2};
    ListNode *res = mergeKLists(lists, 2);
    printList(res);
}
