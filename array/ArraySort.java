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

	public static void selectSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = a[i];
			int min_idx = i;
			/* Find the minimum of the left */
			for (int j = i + 1; j < a.length; j++)
				if (min > a[j]) {
					min = a[j];
					min_idx = j;
				}
			if (min_idx > i) {
				int tmp = a[min_idx];
				a[min_idx] = a[i];
				a[i] = tmp;
			}
		}
	}
}
