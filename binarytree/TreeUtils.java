import java.util.Random;

public class TreeUtils {
	public static BinarySearchTree randomBST(int n, int base) {
		Random r = new Random();
		BinarySearchTree bst = new BinarySearchTree();
		for (int i = 0; i < n; i++)
			bst.insert(r.nextInt() % base);
		return bst;
	}
}
