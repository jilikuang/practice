#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * table[k] is the length of the longest proper suffix of the length k+1 prefix
 * of the pattern p (p0,p1,...,pk).
 */
static int * kmp_failure(const char *p) {
	int l = strlen(p);
	int *table = malloc(l * sizeof(int));
	int i;

	table[0] = 0;	// Initialization
	for (i = 1; i < l; ++i) {
		int k = i - 1;
		int x = table[k];

		while (p[x] != p[i]) {
			/**
			 * If x is valid, it means that for length k prefix,
			 * the longest proper suffix is of length x. At the same
			 * time, x is also the length of the prefix. It also
			 * means to find the longest proper suffix of the prefix
			 * of length x.
			 */
			k = x - 1;
			if (k < 0)
				break;
			x = table[k];
		}

		if (k < 0)
			table[i] = 0;
		else
			table[i] = table[k] + 1;
	}

	return table;
}

static int kmp_search(const char *s, const char *p)
{
	int ls = strlen(s);
	int lp = strlen(p);
	int *t = kmp_failure(p);
	int i = 0, j = 0, i0 = 0;

	while (i < ls) {
		if (s[i] == p[j]) {
			++i;
			++j;
			if (j == lp)
				break;
		} else {
			if (j) {
				j = t[j-1];
				i0 = i - j;	// == i0 += j
			} else {
				i = ++i0;
			}
		}
	}

	free(t);

	if (j == lp)
		return i0;
	return -1;
}

int main(int argc, char **argv)
{
	int index = 0;

	if (argc < 3)
		printf("Not enough input.\n");

	printf("Search \"%s\" in \"%s\"...\n", argv[1], argv[2]);
	index = kmp_search(argv[2], argv[1]);
	if (index < 0)
		printf("The string is not found.\n");
	else
		printf("The string is found at %d.\n", index);

	return 0;
}
