public class Solution {
    public int mySqrt(int x) {
        if (x < 1) return 0;
        int start = 1, end = x;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start)/2;
            if (mid <= (double) x/mid) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end <= (double) x/end)
            return end;
        return start;
    }
}