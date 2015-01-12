import java.util.Random;

public abstract class ArrayUtils {
	public static int[] randomArray(int n) {
		Random r = new Random();
		int[] array = new int[n];

		for (int i = 0; i < n; i++)
			array[i] = r.nextInt();

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
}
