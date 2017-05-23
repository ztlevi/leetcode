public class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return new ArrayList();
        
        // intialize
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList();
        
        int lastNum = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            if (sb.length() == 0) {
                sb.append(nums[i]);
            } else {
                if (nums[i] == lastNum + 1) {
                    if (sb.charAt(sb.length() -1) != '>')
                        sb.append("->");
                } else {
                    if (sb.charAt(sb.length() -1) == '>'){
                        sb.append(lastNum);
                        list.add(new String(sb));
                        sb = new StringBuilder();
                        sb.append(nums[i]);
                    } else {
                        list.add(new String(sb));
                        sb = new StringBuilder();
                        sb.append(nums[i]);
                    }
                }
            }
            lastNum = nums[i];
        }
        
        if (sb.length() !=0 && sb.charAt(sb.length() -1) == '>'){
            sb.append(lastNum);
            list.add(new String(sb));
        } else {
            list.add(new String(sb));
        }
        return list;
    }
}