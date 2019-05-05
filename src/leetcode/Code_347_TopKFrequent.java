package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 17hao
 * @date 2019-05-05 15:21
 */
public class Code_347_TopKFrequent {
    private static List<Integer> topKFrequentElements(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if (!map.containsKey(n)) map.put(n, 1);
            else map.put(n, map.get(n) + 1);
        }
        /* 将hashmap的key、value取出来作为数组，下标相同 */
        int[] keys = new int[map.size() + 1];
        int[] values = new int[map.size() + 1];
        for (int i = 0; i < map.size(); i++) {
            keys[i + 1] = (int) map.keySet().toArray()[i];
            values[i + 1] = (int) map.values().toArray()[i];
        }
        int[] res = new int[k + 1];
        int[] count = new int[k + 1];
        System.arraycopy(keys, 1, res, 1, k);
        System.arraycopy(values, 1, count, 1, k);
        for (int i = 1; i < k + 1; i++) heapInsert(res, count, i);
        for (int i = k + 1; i < values.length; i++) {
            if (values[i] > count[1]) {
                count[1] = values[i];
                res[1] = keys[i];
                heapify(res, count, 1, k);
            }
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i < res.length; i++) list.add(res[i]);
        return list;
    }

    /* 将数组中的元素放到合适位置以形成大（小）顶堆*/
    private static void heapInsert(int[] res, int[] count, int index) {
        while (count[index] < count[index / 2]) {
            swap(res, index, index / 2);
            swap(count, index, index / 2);
            index = index / 2;
        }
    }

    /* 已经形成的小顶堆的根节点发生变化后重新堆化 */
    private static void heapify(int[] keys, int[] values, int i, int n) {
        while (true) {
            int minPos = i;
            if (i * 2 <= n && values[i] > values[i * 2]) minPos = i * 2;
            if (i * 2 + 1 <= n && values[minPos] > values[i * 2 + 1]) minPos = i * 2 + 1;
            if (minPos == i) break;
            swap(keys, minPos, i);
            swap(values, minPos, i);
            i = minPos;
        }
    }

    private static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 0, 1, 4, 9, 7, -3, 1, -4, -8, 4, -7, -3, 3, 2, -3, 9, 5, -4, 0};
        int k = 6;
        List<Integer> res = topKFrequentElements(arr, k);
        for (int n : res) System.out.println(n);
    }
}
