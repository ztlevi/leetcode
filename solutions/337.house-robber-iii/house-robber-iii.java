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
    public int rob(TreeNode root) {
        int money = helper(root);
        return money;
    }
    
    Map<TreeNode, Integer> map = new HashMap();
    
    public int helper(TreeNode node) {
        if (node == null) return 0;
        if (map.containsKey(node)) return map.get(node);
        
        int val = 0;
        if (node.left != null) {
            val += helper(node.left.left) + helper(node.left.right);
        }
        if (node.right != null) {
            val += helper(node.right.left) + helper(node.right.right);
        }
        val = Math.max(val + node.val, helper(node.left) + helper(node.right));
        map.put(node, val);
        return val;
    }
}