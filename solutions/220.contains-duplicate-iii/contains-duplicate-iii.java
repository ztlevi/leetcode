public class Solution {
     public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet();
        if (t < 0 || k < 0 || nums.length < 2) return false;
        
        for (int i = 0; i < nums.length; i++) {
            long leftBoundary = (long) nums[i]-t;
            long rightBoundary = (long) nums[i]+t+1;
            
            SortedSet<Long> subset = set.subSet(leftBoundary, rightBoundary);
            if (subset.size() > 0) return true;
            
            set.add((long) nums[i]);
            
            if (i - k >=0) {
                set.remove((long) nums[i-k]);
            }
        }
        return false;
    }
}