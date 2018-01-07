
public class MergeTowSortedLists {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		if (l1.val > l2.val) {
			ListNode node = new ListNode(l2.val);
			node.next = mergeTwoLists(l1, l2.next);
			return node;
		} else {
			ListNode node = new ListNode(l1.val);
			node.next = mergeTwoLists(l1.next, l2);
			return node;
		}
	}
}
