public class Solution {
    public int lengthLongestPath(String input) {
        if(input == null) return 0;
        LinkedList<Integer> stack = new LinkedList();
        int longestLen = 0;
        String[] l1 = input.split("\n");
        stack.push(l1[0].length()+1);
        if(l1[0].contains(".")) longestLen = l1[0].length();
        int sum = stack.get(0);

        // \tsubdir1  \t\tfile1.ext \t\tsubsubdir1 \tsubdir2
        for(int i = 1; i < l1.length; i++){
            String tab = "\t";
            int lev = l1[i].lastIndexOf(tab) + 1;
            while(lev < stack.size()) {
                sum -= stack.peek();
                stack.pop();
            }
            stack.push(l1[i].length()-lev+1);
            sum += stack.peek();
            if(l1[i].contains("."))
                longestLen = (sum-1>longestLen) ? sum-1 : longestLen;
        }
        return longestLen;
    }
}