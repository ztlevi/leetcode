public class Solution {
    public int maxArea(int[] height) {
        int left = 0; int right = height.length - 1;
        int area = Math.min(height[left], height[right])*(right - left);
        while(left < right){
            if(height[left] > height[right]){
                area = Math.max(height[right]*(right-left), area);
                right--;
            }else if(height[left] < height[right]){
                area = Math.max(height[left]*(right-left), area);
                left++;
            }else{
                area = Math.max(height[left]*(right-left), area);
                right--;
                left++;
            }
        }
        return area;
    }
}