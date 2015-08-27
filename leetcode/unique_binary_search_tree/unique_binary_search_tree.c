#include "../utils.h"

int unique_binary_search_tree(int n)
{
	ALLOC_ARRAY(counts, int, n+1);
	int i, j, ans;

	counts[0] = 1;
	counts[1] = 1;
	for (i = 2; i < n + 1; ++i)
		for (j = 0; j < i; ++j)
			counts[i] += counts[j] * counts[i - j - 1];
	ans = counts[n];
	free(counts);
	return ans;
}

int main(int argc, char **argv)
{
	printf("ans: %d\n", unique_binary_search_tree(4));
	return 0;
}
