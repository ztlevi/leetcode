public class Solution {
    public int numSquares(int n) {
        int max = (int) Math.sqrt(n);
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < n+1; i++) {
            for (int j = (int) Math.sqrt(i); j > 0; j--) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        
        return dp[n];
    }
}