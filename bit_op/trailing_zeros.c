#include <stdlib.h>
#include <stdio.h>

#define VERSION	0

static int trailing_zeros(unsigned int n)
{
	int c = (n) ? 0 : 32;

#if (VERSION == 0)
	while (n) {
		if (n & 0x1)
			break;
		c++;
		n >>= 1;
	}
#endif

	return c;
}

int main(int argc, char **argv)
{
	if (argc > 1)
		printf("# of trailing_zeros: %d\n",
				trailing_zeros(strtol(argv[1], NULL, 0)));
	else
		printf("Need argument\n");

	return 0;
}
