public class LinkedListTest {
	public static void main(String[] args) {
		LinkedListTest test = new LinkedListTest();
		ListNode head = ListUtils.randomList(5);

		ListUtils.printList(head);
		ListNode mid = ListUtils.getMidNode(head);
		ListUtils.printList(mid);
	}
}
