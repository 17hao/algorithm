package tool;

public class CommonTool {
    //交换数组的2个元素
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    //打印数组
    public static void printArray(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
    }
}

