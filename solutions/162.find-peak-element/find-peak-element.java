public class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 0) return 0;
        
        int peek = Integer.MIN_VALUE;
        for (int i : nums) {
            peek = Math.max(peek, i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (peek == nums[i]) {
                return i;
            }
        }
        
        return 0;
    }
}