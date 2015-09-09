#include "../utils.h"

static int numSquares(int num)
{
	ALLOC_ARRAY(mins, int, num + 1);
	int i, j;

	// Initialization
	memset(mins, 0, (num + 1) * sizeof(int));
	for (i = 1; i * i <= num; ++i)
		mins[i * i] = 1;

	for (i = 1; i < num; ++i) {
		// Construct the remaining mins
		for (j = 1; j * j + i <= num; ++j) {
			int idx = j * j + i;

			if (mins[idx] == 0 || mins[idx] > mins[i] + 1)
				mins[idx] = mins[i] + 1;
		}
	}

	array_print_int(mins, num + 1);

	return mins[num];
}

int main(int argc, char **argv)
{
	printf("%d\n", numSquares(13));
	return 0;
}
