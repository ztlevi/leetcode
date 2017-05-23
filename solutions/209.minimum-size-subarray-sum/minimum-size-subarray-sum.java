public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums.length <= 0) return 0;
        int sum = 0, minlen = Integer.MAX_VALUE;
        int start = 0, end = 0;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                minlen = minlen < (end - start + 1) ? minlen : (end - start + 1);
                sum -= nums[start++];
            }
            end++;
        }
        return minlen == Integer.MAX_VALUE ? 0 : minlen;
    }
}