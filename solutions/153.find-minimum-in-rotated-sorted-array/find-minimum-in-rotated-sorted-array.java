public class Solution {
    public int findMin(int[] nums) {
        int target = nums[nums.length-1];
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]<=target) return nums[i];
        }
        
        return -1;
    }
}