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
			int min_idx = i;
			/* Find the minimum of the left */
			for (int j = i + 1; j < a.length; j++)
				if (a[min_idx] > a[j])
					min_idx = j;
			if (min_idx > i) {
				int tmp = a[min_idx];
				a[min_idx] = a[i];
				a[i] = tmp;
			}
		}
	}

	public static void mergeSort(int[] a) {
		int[] wb = new int[a.length];
		mergeSortSplit(a, wb, 0, a.length);
	}

	private static void mergeSortSplit(int[] a, int[] wb, int s, int e) {
		if (s + 1 == e) // a[start] is the only element
			return;

		int m = s + (e - s) / 2;
		mergeSortSplit(a, wb, s, m);
		mergeSortSplit(a, wb, m, e);
		mergeSortMerge(a, wb, s, m, e);
	}

	private static void mergeSortMerge(int[] a, int[] wb, int s, int m, int e) {
		int i = s, j = m, k = 0;
		/* Select to the working buffer */
		while (i < m && j < e) {
			if (a[i] < a[j])
				wb[k++] = a[i++];
			else
				wb[k++] = a[j++];
		}
		while (i < m)
			wb[k++] = a[i++];
		while (j < e)
			wb[k++] = a[j++];
		/* Move back to the main array */
		for (i = s; i < e; i++)
			a[i] = wb[i-s];
	}

	public static void quickSort(int[] a) {
		quickSortSplit(a, 0, a.length);
	}

	private static void quickSortSplit(int[] a, int s, int e) {
		if (s == e || s + 1 == e)
			return;

		int i = s, j = s + 1;
		while (j < e) {
			if (a[j] < a[s]) {
				if (i + 1 == j) { /* There is no > elements */
					i++;
				} else {
					int tmp = a[++i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
			j++;
		}
		if (i > s) {
			int tmp = a[s];
			a[s] = a[i];
			a[i] = tmp;
		}

		quickSortSplit(a, s, i);
		quickSortSplit(a, i+1, e);
	}

	public static void heapSort(int[] a) {
		/* Heapify the array */
		for (int i = a.length / 2 - 1; i >= 0; i--)
			heapSink(a, i, a.length);

		/* Heapsort */
		for (int i = a.length - 1; i > 0; i--) {
			int tmp = a[0];
			a[0] = a[i];
			a[i] = tmp;
			heapSink(a, 0, i);
		}
	}

	private static void heapSink(int[] a, int k, int e) {
		while (k < e / 2) {
			int i = 2 * k + 1;
			int j = 2 * k + 2;
			if (j < e && a[j] > a[i])
				i = j;
			if (a[k] >= a[i])
				break;

			int tmp = a[k];
			a[k] = a[i];
			a[i] = tmp;

			k = i;
		}
	}
}
