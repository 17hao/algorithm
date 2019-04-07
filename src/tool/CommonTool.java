package tool;

/**
 * @author 17hao
 * @update 2019/4/7
 */
public class CommonTool {
    /* 随机整数数组 */
    public static int[] generateArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        printArray(arr);
        return arr;
    }

    /* 随机生成正整数数组 */
    public static int[] generatePositiveArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random() + 1);
        }
        printArray(arr);
        return arr;
    }

    /* 交换数组的2个元素 */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /* 打印数组 */
    public static void printArray(int[] arr) {
        for (int anArr : arr) {
            System.out.print(anArr + " ");
        }
        System.out.print("\n");
    }
}

