/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode rln = new RandomListNode(0);
        RandomListNode ans = rln;
        while(head!=null){
            rln.next = new RandomListNode(head.label);
            if(head.random!=null) {
                rln.next.random = new RandomListNode(head.random.label);
            }
            rln = rln.next;
            head = head.next;
        }
        return ans.next;
    }
}