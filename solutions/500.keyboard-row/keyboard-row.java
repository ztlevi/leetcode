class Solution {
    public String[] findWords(String[] words) {
        Set<Character> row1 = addRow("qwertyuiop");
        Set<Character> row2 = addRow("asdfghjkl");
        Set<Character> row3 = addRow("zxcvbnm");
        ArrayList<String> ans = new ArrayList();
        for (String word : words) {
            boolean belongs = true;
            Set<Character> row = null;
            for (char c : word.toCharArray()) {
                char lc = Character.toLowerCase(c);
                if (row ==null) {
                    if (row1.contains(lc)) {
                        row = row1;
                    } else if (row2.contains(lc)) {
                        row = row2;
                    } else if (row3.contains(lc)) {
                        row = row3;
                    }
                } else {
                    if (!row.contains(lc)){
                        belongs = false;
                        break;
                    }
                }
            }
            if (belongs) 
                ans.add(word);
        }
        return ans.toArray(new String[ans.size()]);
    }
    public Set<Character> addRow(String row) {
        Set<Character> ans = new HashSet();
        for (char c : row.toCharArray()) {
            ans.add(c);
        }
        return ans;
    }
}