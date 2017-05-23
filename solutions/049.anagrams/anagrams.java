public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        List<List<String>> ans = new LinkedList();
        
        for(int i=0; i<strs.length; i++){
            char[] arr = new char[26];
            Arrays.fill(arr, 'a');
            for(int j=0; j<strs[i].length(); j++){
                arr[strs[i].charAt(j)-'a']++;
            }
            String key = new String(arr);
            if(!map.containsKey(key)){
                List<String> li = new LinkedList();
                li.add(strs[i]);
                map.put(key, li);
            }else{
                map.get(key).add(strs[i]);
            }
        }
        
        ans.addAll(map.values());
        return ans;
    }
}