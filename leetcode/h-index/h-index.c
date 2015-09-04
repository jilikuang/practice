#include "../utils.h"

int h_index(int *citations, int citationsSize)
{
	ALLOC_ARRAY(counts, int, citationsSize + 1);
	int total = 0;
	int i;

	for (i = 0; i <= citationsSize; ++i)
		counts[i] = 0;

	for (i = 0; i < citationsSize; ++i)
		if (citations[i] > citationsSize)
			++counts[citationsSize];
		else
			++counts[citations[i]];

	for (i = citationsSize; i >= 0; --i) {
		total += counts[i];
		if (total >= i)
			break;
	}

	free(counts);

	return i;
}

int main(int argc, char **argv)
{
	int citations[3] = {1, 3, 1};

	printf("%d\n", h_index(citations, 3));

	return 0;
}
