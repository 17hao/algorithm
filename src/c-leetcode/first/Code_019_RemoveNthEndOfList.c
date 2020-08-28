/* remove nth end of list

   @since 2020-8-28 Friday 16:28
 */

#include "../ListNode.h"
#include <stdlib.h>

struct ListNode *removeNthFromEnd(struct ListNode *head, int n)
{
    struct ListNode *dummy = malloc(sizeof(struct ListNode));
    dummy->val = 0;
    dummy->next = 0;
    dummy->next = head;
    struct ListNode *pre = dummy;
    while (pre != 0)
    {
        struct ListNode *cur = pre->next;
        for (int i = 0; i < n; i++)
            cur = cur->next;
        if (cur == 0)
        {
            struct ListNode *next = pre->next->next;
            pre->next = next;
            break;
        }
        else
        {
            pre = pre->next;
        }
    }
    return dummy->next;
}

int main(int argc, char const *argv[])
{
    int arr[5] = {1, 2, 3, 4, 5};
    ListNode *res = removeNthFromEnd(linkedlist(arr, 5), 1);
    printList(res);
}
