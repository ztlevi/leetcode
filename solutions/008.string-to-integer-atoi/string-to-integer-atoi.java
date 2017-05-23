public class Solution {
    public int myAtoi(String str) {
        if (str.length() == 0) return 0;
        
        int i = 0;
        // ignore whitespaces
        for (; i < str.length(); i++){
            if (str.charAt(i) == ' ') {} 
            else break;
        }
        
        // set the sign
        int sign = 1;
        if (str.charAt(i) == '-'){
            sign = -1; i++;
        } else if (str.charAt(i) == '+') {
            i++;
        }
        
        long num = 0;
        
        for (; i < str.length(); i++) {
            if ( !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                break;
            } else if (num > Integer.MAX_VALUE)
                break;
            else {
                num *= 10;
                num += str.charAt(i) - '0';
            }
        }
        
        if (sign == 1 && num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign == -1 && num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else return (int)num*sign;

    }
}