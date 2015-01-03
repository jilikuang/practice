public abstract class ListUtils {
	public static void printList(ListNode head) {
		if (head != null) {
			ListNode curr = head;
			System.out.print(curr.val);
			curr = curr.next;
			while (curr != null) {
				System.out.print("," + curr.val);
				curr = curr.next;
			}
			System.out.print("\n");
		}
	}

	public static ListNode randomList(int n) {
		if (n <= 0)
			return null;

		ListNode head = new ListNode();
		ListNode curr = head;
		for (int i = 1; i < n; i++) {
			curr.next = new ListNode();
			curr = curr.next;
		}

		return head;
	}

	public static ListNode reverseList(ListNode head) {
		ListNode curr = head, next = null;
		head = null;
		while (curr != null) {
			next = curr.next;
			curr.next = head;
			head = curr;
			curr = next;
		}
		return head;
	}
}
