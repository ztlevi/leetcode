public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) return new int[0];
        
        Set<Integer> set1 = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        Set<Integer> set2 = new HashSet();
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        
        int idx = 0;
        int[] result = new int[set2.size()];
        for (int i : set2) {
            result[idx++] = i;
        }
        return result;
    }
}
