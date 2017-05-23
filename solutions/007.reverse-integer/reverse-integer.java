public class Solution {
    public int reverse(int x) {
        int ans = 0; int minus = 1;
        if(x<0) minus = -1;
        while(x != 0){
           int res = Math.abs(x % 10);
            if( ans > (Integer.MAX_VALUE-res)/10){
                return 0;
            }
           ans = ans*10 + res;
           x = x/10;
        }
        return minus*ans;
    }
}