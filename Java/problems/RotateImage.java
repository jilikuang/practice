class RotateImage {

	public void transpose(int[][] image) {
		for (int i = 1; i < image.length; i++) {
			for (int j = 0; j < i; j++) {
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
		}
	}

	public void reverseVertical(int[][] image) {
		int i = 0, j = image.length - 1;
		while (i < j) {
			int[] temp = image[i];
			image[i] = image[j];
			image[j] = temp;
			i++;
			j--;
		}
	}

	public void rotateImage(int[][] image, boolean clockwise) {
		if (clockwise) {
			reverseVertical(image);
			transpose(image);
		} else {
			transpose(image);
			reverseVertical(image);
		}
	}

	public void printImage(int[][] image) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < image.length; i++) {
			sb.append('[');
			for (int j = 0; j < image.length; j++) {
				sb.append(image[i][j]);
				sb.append(',');
			}
			sb.append("]\n");
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] image = new int[n][n];
		RotateImage ri = new RotateImage();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				image[i][j] = i * n + j;
		ri.printImage(image);
		ri.rotateImage(image, true);
		ri.printImage(image);
		ri.rotateImage(image, false);
		ri.printImage(image);
	}
}
