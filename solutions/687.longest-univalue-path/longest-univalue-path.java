/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int maxLen = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return maxLen;
    }
    public int helper(TreeNode node){
        if (node == null) return 0;
        int leftValue = 0, rightValue = 0;
        if (node.left != null) {
            leftValue = helper(node.left);
            if (node.left.val == node.val)
                leftValue++;
            else
                leftValue = 0;
        }
        
        if (node.right != null) {
            rightValue = helper(node.right);
            if (node.right.val == node.val)
                rightValue++;
            else
                rightValue = 0;
        }
        

            maxLen = Math.max(maxLen, leftValue + rightValue);

        
        return Math.max(leftValue, rightValue);
        
    }
}