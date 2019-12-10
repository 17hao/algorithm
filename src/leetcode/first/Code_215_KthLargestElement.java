package leetcode.first;

/**
 * @author 17hao
 * @date 2019-05-06 10:14
 */
public class Code_215_KthLargestElement {
    private static int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, k);
        for (int i = 0; i < k; i++) {
            heapInsert(heap, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > heap[0]) {
                heap[0] = nums[i];
                heapify(heap, 0, k - 1);
            }
        }
        return heap[0];
    }

    /* 遍历数组将每个元素放到合适位置形成小顶堆 */
    private static void heapInsert(int[] nums, int index) {
        while (nums[index] < nums[(index - 1) / 2]) {
            int temp = nums[index];
            nums[index] = nums[(index - 1) / 2];
            nums[(index - 1) / 2] = temp;
            index = (index - 1) / 2;
        }
    }

    /* 已形成的小顶堆根节点发生变化后重新堆化 */
    private static void heapify(int[] nums, int index, int size) {
        while (true) {
            int minPos = index;
            if (index * 2 + 1 <= size && nums[minPos] > nums[index * 2 + 1]) minPos = index * 2 + 1;
            if (index * 2 + 2 <= size && nums[minPos] > nums[index * 2 + 2]) minPos = index * 2 + 2;
            if (minPos == index) break;
            int temp = nums[index];
            nums[index] = nums[minPos];
            nums[minPos] = temp;
            index = minPos;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }
}
