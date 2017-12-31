
public class ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}

	public ListNode reverseList(ListNode head) {
		return reverseList(head,null);
	}

	private ListNode reverseList(ListNode head, ListNode newHead) {
		if(head==null)return newHead;
		ListNode node=head.next;
		head.next=newHead;
		return reverseList(node,head);
	}
}
