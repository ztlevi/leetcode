/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
	public ListNode findMid(ListNode head){
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode sortList(ListNode head){
		if(head == null || head.next == null) return head;
		
		ListNode left = new ListNode(0), left2 = left;
		ListNode right = new ListNode(0), right2 = right;
		ListNode mid = new ListNode(0), mid2 = mid;
		int midValue = findMid(head).val;
		
		while(head != null){
			if(head.val < midValue){
				left.next = new ListNode(head.val);
				left = left.next;
			}else if(head.val > midValue){
				right.next = new ListNode(head.val);
				right = right.next;
			}else{
				mid.next = new ListNode(head.val);
				mid = mid.next;
			}
			head = head.next;
		}

		left = sortList(left2.next);
		right = sortList(right2.next);
		mid = mid2.next;
		
		return merge(left, mid, right);
	}

	public ListNode merge(ListNode left, ListNode mid, ListNode right){
		ListNode dummy = new ListNode(0);
		ListNode ans = dummy;
		while(left != null){
			dummy.next = new ListNode(left.val);
			left = left.next;
			dummy = dummy.next;
		}
		while(mid != null){
			dummy.next = new ListNode(mid.val);
			mid = mid.next;
			dummy = dummy.next;
		}
		while(right != null){
			dummy.next = new ListNode(right.val);
			right = right.next;
			dummy = dummy.next;
		}
		return ans.next;
	}
}
