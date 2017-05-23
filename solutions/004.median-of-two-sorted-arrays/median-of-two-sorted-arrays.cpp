class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        if(nums1.size() == 0)
            return static_cast<double>(nums2[(nums2.size())/2] + nums2[(nums2.size() - 1)/2])/2;
        if(nums2.size()  == 0)
            return static_cast<double>(nums1[(nums1.size())/2] + nums1[(nums1.size() - 1)/2])/2;

        int ptr1 = 0; int ptr2 = 0; int counter = 0;
        int mid = (nums1.size() + nums2.size())/2;
        int mid2 = (nums1.size() + nums2.size() - 1)/2;
        double median1, median2;

        while(counter <= mid)
        {
            if((nums1[ptr1] <= nums2[ptr2] && ptr1 < nums1.size()) || ptr2 >= nums2.size()){
                if(counter == mid2)
                    median1 = nums1[ptr1];
                if(counter == mid)
                    median2 = nums1[ptr1];
                ptr1++; counter++;
            }
            else if(ptr2 < nums2.size()){
                if(counter == mid2)
                    median1 = nums2[ptr2];
                if(counter == mid)
                    median2 = nums2[ptr2];
                ptr2++; counter++;
            }
        }

        double median = (median1 + median2)/2;
        return median;
    }
};