package algorithms4th.chapter_2_Sorting.section_1_Elementary;

import tool.CommonTool;

public class Selection {
    private Selection() {
    }

    /**
     * Select the smallest element and exchange it with the first element.
     *
     * @param a the array to be sorted
     */
    static void sort(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[min])
                    min = j;
            }
            CommonTool.swap(a, i, min);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 6, 7, 1, 2, 3, 9};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
