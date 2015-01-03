public class LinkedListTest {
	public static void main(String[] args) {
		LinkedListTest test = new LinkedListTest();
		ListNode head = new ListNode(1);
		ListNode tail = head;

		tail.next = new ListNode(2);
		tail = tail.next;
		tail.next = new ListNode(3);
		tail = tail.next;

		test.printList(head);
		test.reorderList(head);
		test.printList(head);
	}

	public static void printList(ListNode head) {
		if (head != null) {
			ListNode curr = head;

			System.out.print(String.valueOf(curr.val));
			curr = curr.next;
			while (curr != null) {
				System.out.print("," + String.valueOf(curr.val));
				curr = curr.next;
			}

			System.out.print("\n");
		}
	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null)
			return;

		/* Divide the list into two lists */
		ListNode curr = head, h2 = head, t1 = null;

		while (curr != null && curr.next != null) {
			curr = curr.next.next;
			t1 = h2;
			h2 = h2.next;
		}

		t1.next = null;

		/* Reverse the second list */
		curr = h2;
		h2 = null;
		while (curr != null) {
			ListNode next = curr.next;

			curr.next = h2;
			h2 = curr;
			curr = next;
		}

		printList(head);
		printList(h2);

		/* Merge the two lists */
		curr = head;
		t1 = h2;
		while (curr != null) {
			ListNode c1 = curr.next;
			ListNode c2 = t1.next;

			curr.next = t1;
			t1.next = c1;

			curr = c1;
			t1 = c2;
		}
	}
}
