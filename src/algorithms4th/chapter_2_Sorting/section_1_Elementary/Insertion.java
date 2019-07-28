package algorithms4th.chapter_2_Sorting.section_1_Elementary;

import tool.CommonTool;

public class Insertion {
    /**
     * People often use the algorithm to sort bridge hands, insert each into the proper place
     * among those already considered. In a computer implementation, we need to make space for
     * the current item by moving larger items one position to the right, before inserting the
     * current item into the vacated place.
     *
     * @param a the array to be sorted
     */
    static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1])
                    CommonTool.swap(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 2, 9, 12, 1, 0, 7};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
