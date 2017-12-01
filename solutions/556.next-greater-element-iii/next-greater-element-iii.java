class Solution {
    public int nextGreaterElement(int n) {
        char[] chars = (n+"").toCharArray();
        int len = chars.length;
        int rsmall = -1;
        for (int i = len-2; i >= 0; i--) {
            if (chars[i] < chars[i+1]) {
                rsmall = i;
                break;
            } 
        }
        
        if (rsmall == -1) return -1;
        
        int minDiff = Integer.MAX_VALUE;
        int minIdx = rsmall + 1;
        for (int i = rsmall+1; i < len; i++) {
            int curDiff = chars[i] - chars[rsmall];
            if (chars[i] > chars[rsmall] && curDiff < minDiff) {
                minIdx = i;
                minDiff = curDiff;
            }
        }
        
        char temp = chars[rsmall];
        chars[rsmall] = chars[minIdx];
        chars[minIdx] = temp;
        
        Arrays.sort(chars, rsmall+1, len);
        
        long ans = Long.parseLong(new String(chars));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }
}