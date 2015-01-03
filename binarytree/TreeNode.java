import java.util.Random;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
		Random r = new Random();
		val = r.nextInt();
		left = null;
		right = null;
	}

	public TreeNode(int x) {
		val = x;
		left = null;
		right = null;
	}
}
