public class BinaryTreeTest {
	public static void main(String[] args) {
		BinaryTreeTest test = new BinaryTreeTest();
		BinarySearchTree bst = TreeUtils.randomBST(10, 100);

		bst.printInOrder();
		System.out.println("Max: " + bst.max());
		System.out.println("Min: " + bst.min());
	}
}
