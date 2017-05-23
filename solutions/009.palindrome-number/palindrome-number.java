public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int num = x;
        int div = 1;
        while(num > 9){
            num = num/10;
            div*= 10;
        }
        while(div > 0){
            int right = x%10;
            int left = x/div;
            if(right != left){
                return false;
            }
            x = (x-right-left*div)/10;
            div = div/100;
        }
        return true;
    }
}