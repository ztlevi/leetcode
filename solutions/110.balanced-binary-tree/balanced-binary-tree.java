/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        
        if (getHeight(root) == -1) return false;
        else return true;
    }
    
    public int getHeight(TreeNode node) {
        if (node == null) return 0;
        
        int left = getHeight(node.left);
        int right = getHeight(node.right);
        
        if (left == -1 || right == -1) return -1;
        else if (Math.abs(left - right) > 1) {
            return -1;
        } else return Math.max(left, right) + 1;
    }
}