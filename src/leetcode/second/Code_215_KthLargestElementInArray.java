package leetcode.second;

import java.util.PriorityQueue;

/**
 * 数组中第k个大的元素
 *
 * @since 2020-4-15 Wednesday 21:20 - 21:47
 */
public class Code_215_KthLargestElementInArray {
    static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (k > len) k = len;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int num : nums) {
            if (heap.size() < k) {
                heap.add(num);
            } else {
                int tmp = heap.peek();
                if (num > tmp) {
                    heap.remove();
                    heap.add(num);
                }
            }
        }
        return heap.peek();
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        System.out.println(findKthLargest(new int[]{1}, 2));
    }
}
