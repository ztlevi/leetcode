public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int idx1 = m-1, idx2 = n-1;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        } else if (n == 0) {
            return;
        }
        
        for (int i = m+n-1; i >= 0; i--) {
            if (idx1 < 0) {
                nums1[i] = nums2[idx2--];
                continue;
            }else if (idx2 < 0) {
                nums1[i] = nums1[idx1--];
                continue;
            }
            if (nums1[idx1] < nums2[idx2]) {
                nums1[i] = nums2[idx2--];
            }else {
                nums1[i] = nums1[idx1--];
            }
        }
    }
}