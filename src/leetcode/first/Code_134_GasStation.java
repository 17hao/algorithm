package leetcode.first;

/**
 * 加油站
 *
 * @since 2020-6-18 Thursday 14:26
 */
public class Code_134_GasStation {
    static int canCompleteCircuit(int[] gas, int[] cost) {
        int rest = 0, restFromStart = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            restFromStart += (gas[i] - cost[i]); // 从起点出发剩余的油量
            rest += (gas[i] - cost[i]); // 整趟行程最终剩余的油量
            if (restFromStart < 0) {
                start = i + 1;
                restFromStart = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
