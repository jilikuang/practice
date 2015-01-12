public abstract class ArraySort {
	public static void bubbleSort(int[] a) {
		int e = a.length - 1;
		for (int i = 0; i < e; i++)
			/* Push the ith largest number to the right */
			for (int j = 0; j < e - i; j++)
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
	}

	public static void insertSort(int[] a) {
		for (int i = 1; i < a.length; i++)
			/* Push the ith number to the left */
			for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
				int tmp = a[j];
				a[j] = a[j-1];
				a[j-1] = tmp;
			}
	}
}
