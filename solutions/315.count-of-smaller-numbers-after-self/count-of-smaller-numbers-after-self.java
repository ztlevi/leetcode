class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        int[] tree = new int[max - min + 2];
        List<Integer> ans = new ArrayList();

        for (int i = n - 1; i >= 0; i--) {
            int x = get(tree, nums[i] - min);
            ans.add(x);
            update(tree, nums[i] - min + 1);
        }

        Collections.reverse(ans);
        return ans;
    }

    public void update(int[] tree, int n) {
        for (int i = n; i < tree.length; i += i & (-i)) {
            tree[i] += 1;
        }
    }

    public int get(int[] tree, int n) {
        int sum = 0;
        for (int i = n; i > 0; i -= i & (-i)) {
            sum += tree[i];
        }
        return sum;
    }
}