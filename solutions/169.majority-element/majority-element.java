public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for(int i =0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int ans = nums[0] ;
        int maxOcc = 0;
        Iterator<Integer> it = map.keySet().iterator();
        
        while(it.hasNext()){
        	int nextEle = it.next();
            if(map.get(nextEle) > maxOcc){
                ans = nextEle;
                maxOcc = map.get(nextEle);
            }
        }
        return ans;
    }
}