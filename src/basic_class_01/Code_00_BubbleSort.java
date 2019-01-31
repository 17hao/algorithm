package basic_class_01;

public class Code_00_BubbleSort {
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void printArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 0};
        bubbleSort(arr);
        printArray(arr);
    }
}
