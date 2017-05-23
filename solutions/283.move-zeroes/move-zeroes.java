public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        for(int i=0; i<len; i++){
            if(nums[i] == 0) {
                System.arraycopy(nums, i+1, nums, i, nums.length-i-1);
                int[] arr0 = {0};
                System.arraycopy(arr0, 0, nums, nums.length-1, 1);
                i--; len--;
            }
        }
    }
}