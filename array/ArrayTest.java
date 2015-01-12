public class ArrayTest {
	public static void main(String[] args) {
		ArrayTest test = new ArrayTest();
		int[] array = ArrayUtils.randomArray(10);

		ArrayUtils.printArray(array);
	}
}
