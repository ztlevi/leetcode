public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        int lens = words.length;
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (lens == 0) return result;
        
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String s = words[i];

            // if s is palindrome, find ""
            if (isPalindrome(s)) {
                if (map.containsKey("")) {
                    int x = map.get("");
                    if (x != i) {
                        List<Integer> list = new ArrayList();
                        list.add(i);
                        list.add(x);
                        result.add(list);
                        list = new ArrayList();
                        list.add(x);
                        list.add(i);
                        result.add(list);
                    }
                }
            }

            String reverse = new StringBuilder(s).reverse().toString();
            if (map.containsKey(reverse)) {
                int x = map.get(reverse);
                if (x != i) {
                    List<Integer> list = new ArrayList();
                    list.add(i);
                    list.add(x);
                    result.add(list);
                }
            }
            
            for (int j = 1; j <= s.length()-1; j++) {
                String left = s.substring(0, j);
                String right = s.substring(j, s.length());

                // if left is palindrome, find the right part
                if (isPalindrome(left)) {
                    String rightReverse = new StringBuilder(right).reverse().toString();
                    if (map.containsKey(rightReverse)) {
                        int x = map.get(rightReverse);
                        List<Integer> list = new ArrayList();
                        list.add(x);
                        list.add(i);
                        result.add(list);
                    }
                }
                
                // if right is palindrome, find the left part
                if (isPalindrome(right)) {
                    String leftReverse = new StringBuilder(left).reverse().toString();
                    if (map.containsKey(leftReverse)) {
                        int x = map.get(leftReverse);
                        List<Integer> list = new ArrayList();
                        list.add(i);
                        list.add(x);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
         
        int start = 0;
        int end = s.length() - 1;
         
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
         
        return true;
    }
}