package leetcode.second;

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * @since 2019-12-28 Saturday 11:35
 */
public class Code_347_TopKFrequentElements {
    static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Comparator接口定义了优先队列中的优先级, 谁更大谁的优先级高.
        // 此例中前者是父节点, 后者是待插入的数. 待插入数只有比父节点更大才能向上升, compare(待插入数, 父节点数) < 0 否则在末尾. 结果是大顶堆
        // 如果写成(n1, n2) -> map.get(n1) - map.get(n2), 结果是小顶堆.
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (n1, n2) -> map.get(n2) - map.get(n1));
        queue.addAll(map.keySet());
        for (int i = 0; i < k; i++) {
            result.add(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 2, 2, 3}, 2));
        System.out.println(topKFrequent(new int[]{1, 1, 2, 2, 3, 3, 3, 3}, 2));
        System.out.println(topKFrequent(new int[]{1, 1, 2, 2, 3}, 1));
    }
}
