class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int[] tails = new int[len];

        int size = 0;
        for (int n : nums) {
            int s = 0, e = size;
            while (s < e) {
                int m = s + (e-s) / 2;
                if (n > tails[m]) {
                    s = m + 1;
                } else if (n < tails[m])
                    e = m;
                else {
                    e = m;
                }
            }
            tails[s] = n;
            size = Math.max(s + 1, size);
        }
        return size;
    }
}