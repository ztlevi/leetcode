import java.util.*;

class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList();

        findNum(nums, 0, target, 4, new ArrayList<Integer>(), results);
        return results;
    }

    public void findNum(int[] nums, int start, int target, int N, List<Integer> cur, List<List<Integer>> results) {
        if (nums.length < N || N < 2) return;

        if (N == 2) {
            TwoSum(nums, start, target, cur, results);
        } else {
            for (int i = start; i < nums.length - N + 1; i++) {
                if (target < nums[i] * N || target > nums[nums.length-1] * N) {
                    break;
                }
                if (i == start || (i > start && nums[i-1] != nums[i])){
                    cur.add(nums[i]);
                    findNum(nums, i + 1, target - nums[i], N - 1, cur, results);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    public void TwoSum(int[] nums, int start, int target, List<Integer> cur, List<List<Integer>> results) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] == target) {
                List<Integer> ans = new ArrayList(cur);
                ans.add(nums[left]);
                ans.add(nums[right]);
                results.add(ans);
                left++; right--;
                while (left < right && nums[left] == nums[left-1]) {
                    left++;
                }
                while (left < right && nums[right] == nums[right+1]) {
                    right--;
                }
            }
        }
    }

}