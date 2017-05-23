public class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low < high) {
            int mid = (high + low) / 2;
            int count = 0;
            for (int a : nums) {
                if (a <= mid) count++;
            }
            if (count > mid) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
