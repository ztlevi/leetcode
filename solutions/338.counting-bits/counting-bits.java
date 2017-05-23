public class Solution {
    public int[] countBits(int num) {
        int ele = 0; int[] ans = new int[num+1];
        
        for(int i = 1; i <= num; i++){
            ans[i] = ans[i&(i-1)] + 1;
        }

        return ans;
    }
}