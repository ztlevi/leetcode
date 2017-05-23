public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList();
        int threshold = nums.length/3;
        List<Integer> result = new ArrayList();

        Map<Integer, Integer> map = new HashMap();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > threshold) {
                result.add(e.getKey());
            }
        }
        return result;
    }
}