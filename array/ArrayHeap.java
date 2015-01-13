import java.util.Random;

public class ArrayHeap {
	protected int[] heap;
	protected int length;
	protected int height;
	protected int lengthMax;
	protected int minmax;

	private void initiate(int n) {
		n = (n < 0) ? 0 : n;
		if (n == 0) {
			length = 0;
			height = 0;
			lengthMax = 0;
			heap = null;
		} else {
			length = n;
			height = (int)(Math.log(n) / Math.log(2));
			lengthMax = (int)Math.pow(2, height + 1) - 1;
			heap = new int[lengthMax];
		}
	}

	private void randomize() {
		if (length > 0) {
			Random r = new Random();
			for (int i = 0; i < length; i++)
				heap[i] = r.nextInt();
		}
	}

	public ArrayHeap() {
		initiate(0);
		minmax = 0;
	}

	public ArrayHeap(int n) {
		initiate(n);
		randomize();
		minmax = 0;
	}

	public ArrayHeap(int[] a) {
		if (a == null) {
			initiate(0);
		} else {
			initiate(a.length);
			if (length > 0)
				for (int i = 0; i < length; i++)
					heap[i] = a[i];
		}
		minmax = 0;
	}

	public void print() {
		System.out.println("Heap (L = " + length + " / H = " + height + "):");
		System.out.print(heap[0]);
		for (int i = 1; i < length; i++)
			System.out.print("," + heap[i]);
		System.out.print("\n");
	}

	public int[] toArray() {
		if (length == 0) {
			return null;
		} else {
			int[] array = new int[length];
			for (int i = 0; i < length; i++)
				array[i] = heap[i];
			return array;
		}
	}

	public void insert(int val) {
		if (length == lengthMax) {
			int[] old = heap;
			initiate(length+1);
			for (int i = 0; i < old.length; i++)
				heap[i] = old[i];
			heap[old.length] = val;
		} else {
			heap[length++] = val;
		}
		minmax = 0;
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
		if (length > 1)
			for (int i = length / 2 - 1; i >= 0; i--) {
				int idx = i;
				while (idx >= 0)
					idx = localHeapifyMin(idx);
			}
		minmax = -1;
	}

	public boolean hasMin() {
		if (minmax < 0)
			return true;
		return false;
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
		if (length > 1)
			for (int i = length / 2 - 1; i >= 0; i--) {
				int idx = i;
				while (idx >= 0)
					idx = localHeapifyMax(idx);
			}
		minmax = 1;
	}

	public boolean hasMax() {
		if (minmax > 0)
			return true;
		return false;
	}
}
