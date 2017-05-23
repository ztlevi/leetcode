public class WordDistance {
    private HashMap<String, ArrayList<Integer>> map;
        public WordDistance(String[] words) {
            map = new HashMap<String, ArrayList<Integer>>();
            for (int i = 0; i < words.length; i++) {
                ArrayList<Integer> arr;
                if (map.containsKey(words[i])) {
                    arr = map.get(words[i]);
                    arr.add(i);
                } else {
                    arr = new ArrayList<Integer>();
                    arr.add(i);
                    map.put(words[i], arr);
                }
            }
        }
    
        public int shortest(String word1, String word2) {
            ArrayList<Integer> arr1, arr2;
            arr1 = map.get(word1);
            arr2 = map.get(word2);
      
            int shortestDistance = Integer.MAX_VALUE;
            for (int i : arr1) {
                for (int j : arr2) {
                    int distance = Math.abs(i - j);
                    if (distance < shortestDistance)
                        shortestDistance = distance;
                }
            }
            return shortestDistance;
        }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */