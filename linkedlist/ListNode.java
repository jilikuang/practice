import java.util.Random;

public class ListNode {
	int val;
	ListNode next;

	public ListNode() {
		Random r = new Random();
		val = r.nextInt();
		next = null;
	}

	public ListNode(int x) {
		val = x;
		next = null;
	}
}
