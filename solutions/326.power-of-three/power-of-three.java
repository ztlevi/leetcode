public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n==0) return false;
        return n == Math.pow(3, Math.round(Math.log(n)/Math.log(3)));
    }
}