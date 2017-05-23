public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;
        
        if (k >= prices.length - 1)
            return profit(prices); // when k is very large
            
        int[][] local = new int[prices.length][k+1];
        int[][] global = new int[prices.length][k+1];
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i-1][j-1]+Math.max(diff,0),
                                       local[i-1][j] + diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[prices.length-1][k];
    }
    
    public int profit(int[] prices) {
        int profits = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i-1];
            if (diff > 0)
                profits += diff;
        }
        return profits;
    }
}
