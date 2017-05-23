public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int[] pos = new int[s.length()+1];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for(int i = 0; i < s.length(); i++){
            if(pos[i] != -1){
                for(int j = i + 1; j <= s.length(); j++){
                    if(wordDict.contains(s.substring(i, j))){
                        pos[j] = i;
                    }
                }
            }
        }
        return pos[s.length()] != -1;
    }
}