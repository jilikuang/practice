public abstract class ArraySort {
	public static void bubbleSort(int[] a) {
		int e = a.length - 1;
		for (int i = 0; i < e; i++)
			for (int j = 0; j < e - i; j++)
				if (a[j] > a[j+1]) {
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
	}
}
