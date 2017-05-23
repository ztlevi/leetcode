class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.empty()) return 0;
        int index = 0;
        int i = 1;
        while( i < nums.size())
        {
            if(nums[index] != nums[i]){
                nums[++index] = nums[i++];
            }
            else{
                nums[++index] = nums[i];
                while(nums[index] == nums[i])
                    i++;
            }
        }
        return index + 1;
    }
};
