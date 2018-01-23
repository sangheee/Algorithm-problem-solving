public class LinkedListCycle {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}
	
	public boolean hasCycle(ListNode head) {
		
		while(head!=null &&head.next!=null){
			if(head.val==Integer.MIN_VALUE)return true;
			head.val=Integer.MIN_VALUE;
			head=head.next;
		}
		return false;
	}
}
