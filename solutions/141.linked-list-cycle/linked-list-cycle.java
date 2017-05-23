/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet();
        ListNode curr = head;
        while(curr != null){
            if(!set.contains(curr)){
                set.add(curr);
                curr = curr.next;
            }else{
                return true;
            }
        }
        return false;
    }
}