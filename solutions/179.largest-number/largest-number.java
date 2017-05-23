public class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i=0; i<nums.length; i++){
            s[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(s,new Comparator<String>(){
            public int compare(String a, String b){
                return (b+a).compareTo(a+b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length; i++){
            sb.append(s[i]);
        }
        String ans = new String(sb);
        if(ans.charAt(0)=='0') return "0";
        else return ans;
    }
}