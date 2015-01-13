import java.util.Random;

public class ArrayTest {
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayTest test = new ArrayTest();
		int[] array = ArrayUtils.randomArray(7, 100);
		ArrayHeap heap = new ArrayHeap(array);

		heap.heapifyMax();
		heap.print();
		heap.insert(rand.nextInt());
		heap.heapifyMax();
		heap.print();
	}
}
