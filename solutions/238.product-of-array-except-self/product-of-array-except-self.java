public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] product1 = new int[nums.length];
        int[] product2 = new int[nums.length];
        product1[0] = 1; product2[nums.length - 1] = 1;
        
        for(int i = 1; i < nums.length; i++){
            product1[i] = nums[i-1] * product1[i-1];
            product2[nums.length-1-i] = nums[nums.length-i] * product2[nums.length-i];
        }
        for(int i = 0; i < nums.length; i++){
            nums[i] = product1[i] * product2[i];
        }
        return nums;
    }
}