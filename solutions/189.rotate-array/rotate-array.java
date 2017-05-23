public class Solution {
    public void rotate(int[] nums, int k) {
        int lens = nums.length;
        k = k % lens;
        reverse(nums, 0, lens-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, lens-1);
    }
    
    public void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int foo = nums[start];
            nums[start] = nums[end];
            nums[end] = foo;
            start++; end--;
        }
    }
}