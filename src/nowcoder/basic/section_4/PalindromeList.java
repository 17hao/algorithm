package nowcoder.basic.section_4;

import tool.LinkedListTool;
import tool.ListNode;

import java.util.LinkedList;
import java.util.List;

public class PalindromeList {
    boolean chkPalindrome(ListNode head) {
        List<Integer> aux = new LinkedList<>();

        while (head != null) {
            aux.add(head.val);
            head = head.next;
        }

        Integer[] a = aux.toArray(new Integer[0]);
        boolean result = true;
        if (a.length == 1) {
            return true;
        } else {
            for (int i = 0; i <= a.length / 2; i++) {
                if (!a[i].equals(a[a.length - 1 - i])) {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 2, 1, 2};
        ListNode head = LinkedListTool.generateList(a);
        PalindromeList p = new PalindromeList();
        System.out.println(p.chkPalindrome(head));
    }
}
