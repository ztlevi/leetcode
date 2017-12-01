/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: the root of binary tree
     * @return: new root
     */
    TreeNode newRoot;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // write your code here
        if (root == null)
            return null;
        dfs(root);
        return newRoot;
    }

    public void dfs(TreeNode cur) {
        if (cur.left == null) {
            newRoot = cur;
            return;
        }
        dfs(cur.left);
        TreeNode par = cur.left;
        par.right = cur;
        par.left = cur.right;
        cur.left = null;
        cur.right = null;
    }
}