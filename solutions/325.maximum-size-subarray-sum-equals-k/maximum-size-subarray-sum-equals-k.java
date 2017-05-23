public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int max = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1); // 0 is init sum, -1 is init offset of the max
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum-k))
                max = Math.max(max, i - map.get(sum-k));
            if (!map.containsKey(sum))
                map.put(sum, i); // if former subarray contains sum, then don't. Cuz it's the longer subarray
        }
        return max;
    }
}