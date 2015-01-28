import java.util.Stack;

public class BinarySearchTree {
	TreeNode root;

	public void insert(int value) {
		if (root == null) {
			root = new TreeNode(value);
			return;
		}

		TreeNode curr = root;

		while (curr != null) {
			if (value < curr.val)
				if (curr.left == null) {
					TreeNode tmp = new TreeNode(value);
					tmp.left = curr.left;
					curr.left = tmp;
				} else {
					curr = curr.left;
				}
			else if (value > curr.val)
				if (curr.right == null) {
					TreeNode tmp = new TreeNode(value);
					tmp.right = curr.right;
					curr.right = tmp;
				} else {
					curr = curr.right;
				}
			else
				break;
		}
	}

	public TreeNode search(int value) {
		return search(root, value);
	}

	private TreeNode search(TreeNode node, int value) {
		TreeNode curr = node;
		while (curr != null) {
			if (value < curr.val)
				curr = curr.left;
			else if (value > curr.val)
				curr = curr.right;
			else
				break;
		}
		return curr;
	}

	public void printInOrder() {
		TreeNode curr = root;
		Stack<TreeNode> stack = new Stack<>();

		while (curr != null || !stack.empty()) {
			if (curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.print(curr.val + ", ");
				curr = curr.right;
			}
		}
	}
}
