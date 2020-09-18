package archive.basic_class_02;

import leetcode.tool.SortTestTool;

import static leetcode.tool.CommonTool.*;

/*
堆排序
分为heapInsert和heapify 2个过程
heapInsert将一个数组中的数放到合适的位置以形成大堆,遍历数组后形成大根堆,此时arr[0]是最大值
交换arr[0]和arr[length-1],最大的数到了最后位置,此时0到length-2位置上原先的大根堆被破坏
heapify的过程,将父节点被破坏的大根堆重新调整成大根堆
 */
public class Code_02_HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int size = arr.length;
        swap(arr, 0, --size);//等价于size=arr.length-1; swap(arr,0,size)
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    //把数组中的数放到合适的位置,遍历整个数组后形成大根堆
    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //已经形成的大顶堆中件某个父节点发生变化后重新堆化
    public static void heapify(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;//左节点和父节点的关系
        while (left < heapSize) {
            //细节:条件设为arr[left+1]>arr[left]
            int biggest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            biggest = arr[index] > arr[biggest] ? index : biggest;
            if (biggest == index) {
                break;
            }
            swap(arr, index, biggest);
            index = biggest;//被交换的较小的那个数来到biggest位置
            left = index * 2 + 1;
        }

    }

    public static void main(String[] args) {
        int[] arr1 = generateArray(10, 100);
        int[] arr2 = SortTestTool.copyArray(arr1);
        boolean success = true;
        for (int i = 0; i < 100; i++) {
            heapSort(arr1);
            SortTestTool.comparator(arr2);
            if (!SortTestTool.isEqual(arr1, arr2)) {
                success = false;
                printArray(arr1);
                break;
            }
        }
        System.out.print(success ? "nice!" : "fucking fucked!");
    }
}
