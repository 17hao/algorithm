package leetcode.third;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 找到未排序数组中第k大的元素
 * 使用一个小顶堆
 * 每当堆的大小超过k时就把堆顶元素弹出
 * 
 * @since 2020-8-12 Wednesday 17:36 - 18:08
 */
public class Code_215_KthLargestElementInArr {
    static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        System.out.println(Arrays.toString(queue.toArray(new Integer[0])));
        return queue.peek();
    }

    static int _findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int small = l, big = r;
        int i = l, j = r;
        while (i < j) {
            if (nums[i] > nums[r]) {
                swap(nums, i, --big);
                j--;
            } else if (nums[i] < nums[r]) {
                swap(nums, i++, small++);
            } else {
                i++;
            }
        }
        sort(nums, l, small - 1);
        swap(nums, r, big);
        sort(nums, big, r);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println(findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
        System.out.println("====");
        System.out.println(_findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
        System.out.println(_findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
    }
}