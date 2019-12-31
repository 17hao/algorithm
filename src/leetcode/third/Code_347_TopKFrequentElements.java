package leetcode.third;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @since 2019-12-31 Tuesday 14:15
 */
public class Code_347_TopKFrequentElements {
    static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length, (a, b) -> map.get(b) - map.get(a));
        queue.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 2, 3, 1}, 1));
        System.out.println(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(topKFrequent(new int[]{1}, 1));
    }
}
