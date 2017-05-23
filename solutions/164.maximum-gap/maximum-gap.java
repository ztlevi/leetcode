class Buckets {
    int low;
    int high;
    public Buckets() {
        low = -1;
        high = -1;
    }
}

public class Solution {
    //Solution 1: quick solution
    // public int maximumGap(int[] nums) {
    //     if(nums.length < 2) return 0;
    //     Arrays.sort(nums);
    //     int max = 0;
    //     for(int i = 1; i < nums.length; i++) {
    //         max = Math.max(Math.abs(nums[i]-nums[i-1]), max);
    //     }
    //     return max;
    // }
    
    //Solution 2: buckets
    public int maximumGap(int[] nums) {
        if(nums.length < 2) return 0;
        int max = nums[0], min = nums[0];
        
        Buckets[] buckets = new Buckets[nums.length + 1];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new Buckets();
        }
        
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        
        double interval;
        if(max == min) return 0;
        else 
            interval = (double) nums.length/(max - min);

        // put all nums' element into the buckets
        for(int i = 0; i < nums.length; i++) {
            int index = (int) Math.floor( (nums[i] - min) * interval);
            if(buckets[index].low == -1) {
                buckets[index].low = nums[i];
                buckets[index].high = nums[i];
            } else {
                buckets[index].low = Math.min(nums[i], buckets[index].low);
                buckets[index].high = Math.max(nums[i], buckets[index].high);
            }
        }

        // search the max difference in all buckets
        int maxDiff = 0, prev = buckets[0].high;
        for(int i = 1; i < buckets.length; i++) {
            if(buckets[i].low != -1) {
                maxDiff = Math.max(maxDiff, buckets[i].low - prev);
                prev = buckets[i].high;
            }
        }

        return maxDiff;
    }

}