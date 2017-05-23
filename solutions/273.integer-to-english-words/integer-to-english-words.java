public class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        Map<Integer, String> map = new HashMap<>();

        map.put(1, " One"); map.put(2, " Two");
        map.put(3, " Three"); map.put(4, " Four");
        map.put(5, " Five"); map.put(6, " Six");
        map.put(7, " Seven"); map.put(8, " Eight");
        map.put(9, " Nine"); map.put(0, "");
        map.put(11, " Eleven"); map.put(12, " Twelve");
        map.put(13, " Thirteen"); map.put(14, " Fourteen");
        map.put(15, " Fifteen"); map.put(16, " Sixteen");
        map.put(17, " Seventeen"); map.put(18, " Eighteen");
        map.put(19, " Nineteen"); 
        map.put(10, " Ten"); map.put(20, " Twenty");
        map.put(30, " Thirty"); map.put(40, " Forty");
        map.put(50, " Fifty"); map.put(60, " Sixty");
        map.put(70, " Seventy"); map.put(80, " Eighty");
        map.put(90, " Ninety");

        String[] n1000 = { " Thousand", " Million", " Billion"};
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            int digit1 = num - num/10*10;
            int digit2 = (num - num/100*100 - digit1)/10;
            int digit3 = (num - num/1000*1000 - digit2*10 - digit1)/100;

            if (digit2 == 0) {
                sb.insert(0, map.get(digit1));
            } else if (digit2 == 1) {
                sb.insert(0, map.get(digit1 + 10));
            } else {
                sb.insert(0, map.get(digit1));
                sb.insert(0, map.get(digit2 * 10));
            }

            if (digit3 != 0) {
                sb.insert(0, map.get(digit3) + " Hundred");
            }

            num /= 1000;
            if (digit1 == 0 && digit2 == 0 && digit3 == 0
                && num-num/1000*1000 != 0) // num的后三位不为000,排除1 000 010的情况
                sb.insert(0, n1000[count]);
            
            if ((digit1 !=0 || digit2 != 0 || digit3 != 0) 
                && num-num/1000*1000 != 0) // num的后三位不为000,排除1 000 010的情况
                sb.insert(0, n1000[count]);
            count++;
            
        }
        return new String(sb.substring(1, sb.length()));
    }
}
