public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0]; int maxPlen = prefix.length();
        for(int i = 1; i < strs.length; i++){
            int j = 0; String currStr = strs[i];
            while(j < maxPlen && j < currStr.length() && prefix.charAt(j) == currStr.charAt(j)){
                j++;
            }
            maxPlen = (j < maxPlen)?j:maxPlen;
        }
        if(maxPlen == 0) return "";
        else{
            prefix = prefix.substring(0, maxPlen);
                    return prefix;
        }
    }
}