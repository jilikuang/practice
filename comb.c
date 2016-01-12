#include <stdio.h>
#include <stdlib.h>

int comb(int n, int k)
{
	int i, ans = 1;

	if (k == 0 || k == n)
		return 1;
	if (k > n - k)
		k = n - k;
	for (i = 1; i <= k; ++i) {
		ans *= n - i + 1;
		ans /= i;
	}
	return ans;
}

int main(int argc, char **argv)
{
	int n = strtol(argv[1], NULL, 0);
	int k = strtol(argv[2], NULL, 0);

	printf("%d\n", comb(n, k));

	return 0;
}
