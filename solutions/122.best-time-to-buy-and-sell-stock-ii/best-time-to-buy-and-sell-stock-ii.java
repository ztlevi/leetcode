public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0; int left = prices[0], right = left;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] <= left){
                left = prices[i];
            }else{
                right = prices[i];
                profit += right - left;
                left = right;
            }
        }
        return profit;
    }
}