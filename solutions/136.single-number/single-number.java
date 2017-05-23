public class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }else{
                set.remove(nums[i]);
            }
        }
        Iterator<Integer> it = set.iterator();
        return it.next();
    }
}
