public class Solution {
    public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }

        int i = 0; 
        while (i < A.length) {
            if (A[i] != i+1 && A[i] < A.length && A[i] > 0 && A[i] != A[A[i]-1]) {
                int tmp = A[i] - 1;
                A[i] = A[tmp];
                A[tmp] = tmp + 1;
            } else {
                i++;
            }
        }

        for (i = 0; i < A.length; i++) {
            if (A[i] != i+1)
                return i+1;
        }

        return A.length+1;
    }
}