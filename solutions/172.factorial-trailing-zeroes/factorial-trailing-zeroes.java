public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        for(long i = 5; n >= i; i = i*5){
            count += n/i;
        }
        return count;
    }
}