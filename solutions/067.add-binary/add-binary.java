public class Solution {
    public String addBinary(String a, String b) {
        int aIdx = a.length() - 1, bIdx = b.length() - 1;
        int carry = 0; String ans = "";
        int idx0 = (int)'0';
        
        while (aIdx >= 0 || bIdx >= 0) {
            int n1, n2;
            if (aIdx < 0) {
                n1 = 0;
            } else {
                n1 = a.charAt(aIdx) - idx0;
            }
            if (bIdx < 0) {
                n2 = 0;
            } else {
                n2 = b.charAt(bIdx) - idx0; 
            }
            int sum = n1 + n2 + carry;
            switch(sum){
                case 0: carry = 0;
                        ans = '0' + ans;
                        break;
                case 1: carry = 0;
                        ans = '1' + ans;
                        break;
                case 2: carry = 1;
                        ans = '0' + ans;
                        break;
                case 3: carry = 1;
                        ans = '1' + ans;
                        break;
            }
            aIdx--; bIdx--;
        }
        if (carry == 1) ans = '1' + ans;
        return ans;
    }
}