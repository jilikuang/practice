#include <stdio.h>
#include <string.h>

int main(int argc, char **argv) {
	unsigned int bitmaps[8] = {0, 0, 0, 0, 0, 0, 0, 0};
	int i, l;

	if (argc < 2) {
		printf("Need a string input\n");
		return -1;
	}

	l = strlen(argv[1]);

	for (i = 0; i < l; i++) {
		int c = (int)argv[1][i];
		int d = 0;

		while (c >= 0) {
			if (c < 32)
				break;
			d++;
			c -= 32;
		}

		if ((bitmaps[d] >> c) & 0x1)
			break;

		bitmaps[d] |= (0x1 << c);
	}

	if (i == l)
		printf("The input has unique characters\n");
	else
		printf("The input has duplicate characters\n");

	return 0;
}
