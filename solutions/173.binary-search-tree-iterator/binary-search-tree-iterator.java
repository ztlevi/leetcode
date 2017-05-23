/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    LinkedList<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new LinkedList();
        TreeNode curr = root;
        while(curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.peek();
        if (!stack.isEmpty() && stack.get(0).right != null){
        	TreeNode right = stack.get(0).right;
        	stack.pop();
	        while(right != null) {
                stack.push(right);
                right = right.left;
            }
        }else{
        	stack.pop();
        }
        return curr.val;
    }
    
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */