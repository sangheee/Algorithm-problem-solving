import java.util.*;

public class LinkedListComponents {
	public int numComponents(ListNode head, int[] G) {
		int res=0;
		Set<Integer> g=new HashSet<>();
		for(int i:G)g.add(i);
		boolean flag=false;
		while(head!=null) {
			if(g.contains(head.val) && !flag) {
				res++;
				flag=true;
			}
			if(flag && !g.contains(head.val)) {
				flag=false;
			}
			head=head.next;
		}
		return res;
	}
}
