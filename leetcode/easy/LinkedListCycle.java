import java.util.*;

public class LinkedListCycle {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){val=x;}
	}
	
	public boolean hasCycle(ListNode head) {
		Set<ListNode> isAppear=new HashSet<>();
		while(head!=null){
			if(isAppear.contains(head))return true;
			isAppear.add(head);
			head=head.next;
		}
		return false;
	}
}
