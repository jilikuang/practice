import java.util.Random;

public class ArrayTest {
	public static void main(String[] args) {
		Random rand = new Random();
		ArrayTest test = new ArrayTest();
		int[] array = ArrayUtils.randomArray(11, 100);

		ArrayUtils.printArray(array);
		System.out.println(ArrayUtils.isSorted(array));

		ArraySort.heapSort(array);

		ArrayUtils.printArray(array);
		System.out.println(ArrayUtils.isSorted(array));
	}
}
