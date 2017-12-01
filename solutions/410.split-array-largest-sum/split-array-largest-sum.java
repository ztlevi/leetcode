class Solution {
    public int splitArray(int[] nums, int m) {
        int len = nums.length;
        Integer[][] dp = new Integer[m+1][len];
        
        return split(nums, 0, m, dp);
        
    }
    
    public int split(int[] nums, int start, int m, Integer[][] dp){
        int len = nums.length;
        if (start >= len || m < 1) return Integer.MAX_VALUE;
        if (m == 1) {
            int sum = 0;
            for (int i = start; i < len; i++){
                sum += nums[i];
            }
            return sum;
        }
        if (dp[m][start] != null) return dp[m][start];
        int sum = 0, res = Integer.MAX_VALUE;
        for (int i = start; i < len; i++) {
            sum += nums[i];
            int splitVal = Math.max(sum, split(nums, i+1, m-1, dp));
            res = Math.min(res, splitVal);
        }
        dp[m][start] = res;
        return res;
    }
}