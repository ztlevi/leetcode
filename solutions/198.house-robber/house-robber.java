public class Solution {
    public int rob(int[] nums) {
        int sum = 0, lastSum = 0;
        for(int i = 0; i< nums.length; i++){
            int foo = sum;
            sum = Math.max(lastSum + nums[i], sum);
            lastSum = foo;
        }
        return sum;
    }
}