import java.util.Random;

public class ArrayTest {
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayTest test = new ArrayTest();
		int[] array = ArrayUtils.randomArray(8, 10);
		ArrayHeap heap = new ArrayHeap(array);

		ArraySort.bubbleSort(array);
		ArrayUtils.printArray(array);
		int i = ArrayUtils.binarySearch(array, -9);
		if (i < 0)
			System.out.println("No find");
		else
			System.out.println("The index is " + i);
	}
}
