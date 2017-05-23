public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();
        int[] num = new int[n1.length() + n2.length() - 1];

        for (int i = 0; i < n1.length(); i++) {
            for (int j = 0; j < n2.length(); j++) {
                num[i+j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < num.length; i++) {
            int mod = num[i] % 10;
            int carry = num[i] / 10;
            if (i == num.length - 1) {
                if (carry != 0) {
                    sb.insert(0, mod);
                    sb.insert(0, carry);
                } else {
                    sb.insert(0, mod);
                }
                break;
            }
            num[i+1] += carry;
            sb.insert(0, mod);
        }
        
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}