public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++)
        {
            int foo = target - nums[i];
            if(map.containsKey(foo) && map.get(foo) != i)
                return new int[] {i, map.get(foo)};
        }        
        throw new IllegalArgumentException("No two sum solution");
    }
}