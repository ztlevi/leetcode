public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> li = new LinkedList();
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i=0; i<len-2; i++){
            int j = i+1, k = len-1;
            while(j<k){
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer> temp = new LinkedList();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    if(!li.contains(temp)) li.add(temp);
                    j++;k--;
                }
                else if(nums[i]+nums[j]+nums[k]<0){
                    j++;
                }else k--;
            }
        }
        return li;
    }
}