class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int first = 0; int last = nums.size();
        int mid = (first + last)/2;
        while(first != last){
            if(nums[mid] == target)
                return true;
            if(nums[first] < nums[mid]){
                if(target < nums[first] || target > nums[mid])
                    first = mid + 1;
                else
                    last = mid;
            }
            else if(nums[first] > nums[mid]){
                if(target >= nums[first] || target < nums[mid])
                    last = mid;
                else
                    first = mid + 1;
            }
            else
                first++;
            mid = (first + last)/2;
        }
        return false;
    }
}; 