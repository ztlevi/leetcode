public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        
        int x = n&(n-1);
        if (x == 0)
            return true;
        else return false;
    }
}