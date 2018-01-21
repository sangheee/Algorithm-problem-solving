
public class PalindromeLinkedList {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}
	public boolean isPalindrome(ListNode head) {
		ListNode l=head,r=head;
		while(l!=null && l.next!=null){
			l=l.next.next;
			r=r.next;
		}
		if(l!=null)r=r.next;
		
		r=reverse(r);
		l=head;
		
		
		while(r!=null){
			if(l.val!=r.val)return false;
			r=r.next;
			l=l.next;
		}
		return true;
	}
	
	private ListNode reverse(ListNode head) {
		ListNode node=null;
		while(head!=null){
			ListNode next=head.next;
			head.next=node;
			node=head;
			head=next;
		}
		return node;
	}
}
