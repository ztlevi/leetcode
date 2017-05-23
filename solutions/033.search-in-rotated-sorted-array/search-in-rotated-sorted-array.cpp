class Solution {
public:
    int search(const vector<int>& nums, int target) {
        int first = 0; int last = nums.size();
        int mid = (first + last)/2;
        if(nums[mid] == target)
            return mid;
        while(first != last)
        {
            mid = (first + last)/2;
            if(nums[mid] == target)
                return mid;
            else{
                if(nums[first] <= nums[mid]){
                    if(nums[mid] < target || target < nums[first]){
                        first = mid + 1;
                    }
                    else{
                        last = mid;
                    }
                }
                else{
                    if(target >= nums[first] || target < nums[mid]){
                        last = mid;
                    }
                    else{
                        first = mid + 1;
                    }
                }
            }
        }
        return -1;
    }
};