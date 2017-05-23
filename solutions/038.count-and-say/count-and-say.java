public class Solution {
    public String countAndSay(int n) {
        String s = "1";

        for(int i = 1; i < n; i++){
            StringBuilder sb = new StringBuilder();
            Character lastChar =null; int count = 0; 
			for(Character c : s.toCharArray()){
                if(c != lastChar){
                    if(count != 0){
                        sb.append(count);
                        sb.append(lastChar);
                    }
                    count = 1;
                }else{
                    count++;
                }
                lastChar = c;
            }
            sb.append(count);
            sb.append(lastChar);
            s = new String(sb);
        }
        return s;
    }
}