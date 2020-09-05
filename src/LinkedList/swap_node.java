package LinkedList;
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class swap_node {
	static class ListNode {
		      int val;
		     ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		  }
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next.next = new ListNode(4);
		swap_node ob1 =new swap_node();
		ListNode itr=ob1.swapPairs(root);
		while(itr!=null) {
			System.out.print(itr.val + "-->");
			itr=itr.next;
		}
	}
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
        ListNode prev = null, p1 = head, p2 = head.next, newHead = head.next;
        
        while (p1 != null && p2 != null) {
            p1.next = p2.next;
            p2.next = p1;
            if (prev != null) prev.next = p2;
            prev = p1;
            p1 = p1.next;
            if (p1 == null) break;
            p2 = p1.next;
        }
        return newHead;
	}
	//recursive
	public ListNode swapPairs1(ListNode head) {
        
        // Base case / If linked list has 0 or 1 nodes.
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode second = head.next;
        head.next = swapPairs(second.next);
        second.next = head;            
                
        return second; // which is now the new 'head'.
    }
}
