class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length + 1];
        for (int i = 0; i < flowers.length; i++) days[flowers[i] - 1] = i + 1; // days[pos] = day

        int left = 0, right = k + 1, res = Integer.MAX_VALUE;
        for (int i = 0; right < flowers.length; i++) {
            if (i == left) {
                continue;
            } else if (i == right) {
                res = Math.min(res, Math.max(days[left], days[right]));
                left = i;
                right = i + k + 1;
            } else if (days[i] < days[left] || days[i] < days[right]) {
                left = i;
                right = i + k + 1;
            }
        }
        return res != Integer.MAX_VALUE ? res : -1;
    }
}