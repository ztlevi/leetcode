public class Solution {
public int trap(int[] height) {
        if(height.length == 0) return 0;
        int left = 0, right = height.length-1;
        int water = 0;
        int leftHeight = height[left], rightHeight = height[right];
        while(left<right) {
                if(leftHeight < rightHeight) {
                    left++;
                    if(leftHeight > height[left]){
                        water += leftHeight - height[left];
                    }else{
                        leftHeight = height[left];
                    }
                }else{
                    right--;
                    if(rightHeight > height[right]){
                        water += rightHeight - height[right];
                    }else{
                        rightHeight = height[right];
                    }
                }
        }
        return water;
}

}