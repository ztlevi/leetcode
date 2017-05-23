public class Solution {
    int[] nums;
    int[] randoms;
    Random r;
    public Solution(int[] nums) {
        this.nums = nums;
        this.randoms = Arrays.copyOf(nums, nums.length);
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        randoms = Arrays.copyOf(nums, nums.length);
        return randoms;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i=0; i<randoms.length; i++){
            int pos = r.nextInt(randoms.length);
            int foo = randoms[i];
            randoms[i] = randoms[pos];
            randoms[pos] = foo;
        }
        return randoms;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */