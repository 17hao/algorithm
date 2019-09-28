package nowcoder.basic.section_2;

public class MergeSort {
    void mergeSort(int[] arr) {
        if (arr.length <= 1) return;
        else process(arr, 0, arr.length - 1);

    }

    private void process(int[] arr, int l, int r) {
        if (r == l) return;
        else {
            int m = l + ((r - l) >> 1);
            process(arr, l, m);
            process(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p = l;
        int q = m + 1;
        while (p <= m && q <= r) {
            help[i++] = arr[p] < arr[q] ? arr[p++] : arr[q++];
        }
        while (p <= m) {
            help[i++] = arr[p++];
        }
        while (q <= r) {
            help[i++] = arr[q++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = {5, 4, 3, 2, 2, 1};
        int[] c = {1};
        int[] d = {3, 2, 1, 9, 6, 2, 0};
        MergeSort ms = new MergeSort();
        ms.mergeSort(d);
        for (int i : d) {
            System.out.print(i + " ");
        }
    }
}
