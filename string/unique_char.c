#include <stdio.h>
#include <string.h>

static int unique_characters(char *str) {
	unsigned int bitmaps[8] = {0, 0, 0, 0, 0, 0, 0, 0};
	int i, l = strlen(str);
	int c, d;

	if (l > 256)
		return 0;

	for (i = 0; i < l; i++) {
#if 0
		c = (int)str[i];
		d = 0;

		while (c >= 0) {
			if (c < 32)
				break;
			d++;
			c -= 32;
		}
#else
		c = (int)str[i];
		d = c / 32;
		c = c % 32;
#endif

		if ((bitmaps[d] >> c) & 0x1)
			break;

		bitmaps[d] |= (0x1 << c);
	}

	return i == l;
}

int main(int argc, char **argv) {

	if (argc < 2) {
		printf("Need a string input\n");
		return -1;
	}


	if (unique_characters(argv[1]))
		printf("The input has unique characters\n");
	else
		printf("The input has duplicate characters\n");

	return 0;
}
