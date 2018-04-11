import java.util.*;

public class SortList {
	/*public ListNode sortList(ListNode head) {
		List<Integer> tmp=new ArrayList<>();
		ListNode ptr=head;
		for(;ptr!=null;ptr=ptr.next) { //O(n)
			tmp.add(ptr.val);
		}
		Collections.sort(tmp);//O(nlogn)
		ptr=head;
		for(int i:tmp) { //O(n)
			ptr.val=i;
			ptr=ptr.next;
		}
		//O(n+nlogn+n)=O(nlogn+2n)=O(nlogn)
		return head;
	}
	*/

	private ListNode sortList(ListNode head) {
		if (head == null||head.next==null)return head;

		ListNode slow = head, fast = head,mid=head;
		
		while (fast!=null && fast.next!=null) {
			mid=slow;
			slow=slow.next;
			fast=fast.next.next;
		}
		 mid.next=null;

		ListNode left = sortList(head);
		ListNode right= sortList(slow);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		if(left==null || right==null)return left==null?right:left;
		
		ListNode res=new ListNode(0);
		ListNode resTail=res;
		
		while (left != null && right != null) {
			if (left.val < right.val) {
				resTail.next=left;
				left=left.next;
			} else {
				resTail.next=right;
				right=right.next;
			}
			resTail = resTail.next;
		}

		while (left != null) {
			resTail.next = left;
			resTail = resTail.next;
			left = left.next;
		}

		while (right != null) {
			resTail.next = right;
			resTail = resTail.next;
			right=right.next;
		}
		return res.next;
	}

}
