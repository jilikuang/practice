import java.util.Random;

public abstract class ArrayUtils {
	public static int[] randomArray(int n) {
		Random r = new Random();
		int[] array = new int[n];

		for (int i = 0; i < n; i++)
			array[i] = r.nextInt();

		return array;
	}

	public static int[] randomArray(int n, int m) {
		Random r = new Random();
		int [] array = new int[n];

		for (int i = 0; i < n; i++)
			array[i] = r.nextInt() % m;

		return array;
	}

	public static void printArray(int[] a) {
		if (a.length > 0) {
			System.out.print(a[0]);
			for (int i = 1; i < a.length; i++)
				System.out.print("," + a[i]);
			System.out.print("\n");
		}
	}

	public static int binarySearch(int[] a, int key) {
		int l = 0;
		int r = a.length;
		while (l < r) {
			int m = l + (r - l) / 2;
			if (a[m] == key)
				return m;
			else if (a[m] < key)
				l = m + 1;
			else
				r = m;
		}
		return -1;
	}
}
