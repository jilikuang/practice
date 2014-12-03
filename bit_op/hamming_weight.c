#include <stdlib.h>
#include <stdio.h>

static int hamming_weight(unsigned int n)
{
	int c = 0;

	while (n) {
		c++;
		n &= (n - 1);
	}

	return c;
}

int main(int argc, char **argv)
{
	if (argc > 1)
		printf("# of ones: %d\n",
				hamming_weight(strtol(argv[1], NULL, 0)));
	else
		printf("Need arguments\n");

	return 0;
}
