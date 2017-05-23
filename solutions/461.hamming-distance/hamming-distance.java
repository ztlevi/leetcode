public class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int distance = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                distance++;
                n = (n-1)/2;
            } else n /= 2;
        }
        return distance;
    }
}