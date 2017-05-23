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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int leftLen = maxDepth(root.left);
        int rightLen = maxDepth(root.right);
        
        int len = Math.max(leftLen, rightLen);
        return ++len;
    }
    
}