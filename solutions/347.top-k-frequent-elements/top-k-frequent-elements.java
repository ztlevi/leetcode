public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        
        int max = 0;
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            max = Math.max(max, e.getValue());
        }
        
        ArrayList<Integer>[] arr = new ArrayList[max+1];
        for (int i = 0; i < max+1; i++) {
        	arr[i] = new ArrayList<Integer>();
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            arr[e.getValue()].add(e.getKey());
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;
        for (int i = max; i >= 0; i--) {
        	if (!arr[i].isEmpty()) {
        		for (int e : arr[i]) {
        		    if (count < k){
        		        result.add(e); 
        		        count++;
        		    }
        		}
        	}
        }
        return result;
    }
}