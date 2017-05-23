public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> list = new HashSet();
        if (k == 0) return false;
        int i = 0;
        while (i < k && i < nums.length) {
            if (!list.contains(nums[i]) ) list.add(nums[i]);
            else return true;
            i++;
        }
        
        for (i = k; i < nums.length; i++) {
            if (!list.contains(nums[i]) ) {
                list.remove(nums[i-k]);
                list.add(nums[i]);
            } else return true;
        }
        return false;
    }
}