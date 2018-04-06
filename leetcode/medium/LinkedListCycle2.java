import org.junit.Test;

public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		ListNode rabbit=head,turtle=head;
		
		while(rabbit!=null &&turtle!=null) {
			turtle=turtle.next;
			rabbit=rabbit.next;
			if(rabbit==null)break;
			rabbit=rabbit.next;
			
			if(rabbit==turtle) {
				rabbit=head;
				while(rabbit!=turtle) {
					rabbit=rabbit.next;
					turtle=turtle.next;
				}
				return rabbit;
			}
		}
		
		return null;
	}
	@Test
	public void test() {
		detectCycle(new ListNode(1));
	}
}
