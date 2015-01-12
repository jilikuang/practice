public class ArrayTest {
	public static void main(String[] args) {
		ArrayTest test = new ArrayTest();
		int[] array = ArrayUtils.randomArray(20, 100);

		ArrayUtils.printArray(array);
		ArraySort.bubbleSort(array);
		ArrayUtils.printArray(array);
	}
}
