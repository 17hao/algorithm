package leetcode.zeroth;

/**
 * @author 17hao
 * @date 2019-04-20 17:12
 */
public class Code_121_BestTimeBuyStock {
    /* max(前i-1天最大收益，第i天价格 - 前i-1天最低价) */
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices.length > 0 ? prices[0] : 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {};
        //int[]prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }
}
