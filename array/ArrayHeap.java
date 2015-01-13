import java.util.Random;

public class ArrayHeap {
	protected int[] heap;
	protected int length;
	protected int height;

	private void initiate(int n) {
		n = (n < 1) ? 1 : n;
		length = n;
		height = (int)(Math.log(n) / Math.log(2));
		n = (int)Math.pow(2, height + 1) - 1;
		heap = new int[n];
	}

	private void randomize() {
		Random r = new Random();
		for (int i = 0; i < length; i++)
			heap[i] = r.nextInt();
	}

	public ArrayHeap() {
		initiate(10);
		randomize();
	}

	public ArrayHeap(int n) {
		initiate(n);
		randomize();
	}

	public ArrayHeap(int[] a) {
		initiate(a.length);
		for (int i = 0; i < length; i++)
			heap[i] = a[i];
	}

	public void print() {
		System.out.println("Heap (L = " + length + " / H = " + height + "):");
		System.out.print(heap[0]);
		for (int i = 1; i < length; i++)
			System.out.print("," + heap[i]);
		System.out.print("\n");
	}

	public int[] toArray() {
		int[] array = new int[length];
		for (int i = 0; i < length; i++)
			array[i] = heap[i];
		return array;
	}

	private int localHeapifyMin(int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (r < length && heap[r] < heap[i]) {
			if (heap[r] < heap[l]) {
				int tmp = heap[i];
				heap[i] = heap[r];
				heap[r] = tmp;
				return r;
			} else {
				int tmp = heap[i];
				heap[i] = heap[l];
				heap[l] = tmp;
				return l;
			}
		} else if (l < length && heap[l] < heap[i]) {
			int tmp = heap[i];
			heap[i] = heap[l];
			heap[l] = tmp;
			return l;
		}
		return -1;
	}

	public void heapifyMin() {
		for (int i = length / 2 - 1; i >= 0; i--) {
			int idx = i;
			while (idx >= 0)
				idx = localHeapifyMin(idx);
		}
	}

	private int localHeapifyMax(int i) {
		int l = 2 * i + 1;
		int r = 2 * i + 2;
		if (r < length && heap[r] > heap[i]) {
			if (heap[r] > heap[l]) {
				int tmp = heap[i];
				heap[i] = heap[r];
				heap[r] = tmp;
				return r;
			} else {
				int tmp = heap[i];
				heap[i] = heap[l];
				heap[l] = tmp;
				return l;
			}
		} else if (l < length && heap[l] > heap[i]) {
			int tmp = heap[i];
			heap[i] = heap[l];
			heap[l] = tmp;
			return l;
		}
		return -1;
	}

	public void heapifyMax() {
		for (int i = length / 2 - 1; i >= 0; i--) {
			int idx = i;
			while (idx >= 0)
				idx = localHeapifyMax(idx);
		}
	}
}
