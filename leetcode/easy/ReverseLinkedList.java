
public class ReverseLinkedList {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {val = x;}
	}

	public ListNode reverseList(ListNode head) {
		ListNode result=null;
		
		while(head!=null){
			ListNode node=new ListNode(head.val);
			node.next=result;
			result=node;
			head=head.next;
		}
		return result;
	}
}
