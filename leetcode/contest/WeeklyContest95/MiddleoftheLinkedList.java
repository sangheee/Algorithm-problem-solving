package contest.WeeklyContest95;

public class MiddleoftheLinkedList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){val=x;}
    }

    public ListNode middleNode(ListNode head) {
        ListNode a=head,b=head;
        while (b!=null &&b.next!=null ){
            a=a.next;
            b=b.next.next;
        }
        return a;
    }

}
