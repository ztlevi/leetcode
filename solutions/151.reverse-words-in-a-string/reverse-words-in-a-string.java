public class Solution {
    public String reverseWords(String s){
        String result = new String();
        String[] words = s.split(" ");
        if(words.length == 0 || s.length() == 0) return result;

        for(int i = words.length - 1; i >=0; i--) {
            if (!words[i].equals(""))
                result += words[i] + " ";
        }
        return result.substring(0, result.length() -1);
    }
}