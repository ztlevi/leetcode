public class Solution {
    public int missingNumber(int[] nums) {
        int lens = nums.length, ans = 0;
        
        for(int i = 0; i < lens; i++) {
            ans += i+1-nums[i];
        }
        
        return ans;
    }

}