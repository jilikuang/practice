public class ArrayTest {
	public static void main(String[] args) {
		ArrayTest test = new ArrayTest();
		int[] array = ArrayUtils.randomArray(20, 100);
		ArrayHeap heap = new ArrayHeap(array);

		ArrayUtils.printArray(array);
		ArraySort.mergeSort(array);
		ArrayUtils.printArray(array);
		heap.print();
	}
}
