public class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;
        
        for(int e : nums) {
            set.add(e);
        }

        for(int e : nums) {
            int left = e-1, right = e+1, count = 1;
            
            while(set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while(set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

}