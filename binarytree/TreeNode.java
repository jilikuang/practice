import java.util.Random;

public class TreeNode {
	int val;
	int size;
	int height;
	TreeNode left;
	TreeNode right;

	public TreeNode() {
		Random r = new Random();
		val = r.nextInt();
		size = 1;
		height = 0;
		left = null;
		right = null;
	}

	public TreeNode(int x) {
		val = x;
		size = 1;
		height = 0;
		left = null;
		right = null;
	}
}
