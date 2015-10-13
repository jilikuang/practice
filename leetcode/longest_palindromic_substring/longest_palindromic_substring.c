#include "../utils.h"

char * longestPalindrome(const char *s)
{
	int l = strlen(s);
	int max_start = 0;
	int max_len = 0;
	int i;
	char *ans = NULL;

	for (i = 0; i < l; ++i) {
		int a = i, z = i;

		if (l - i <= max_len / 2)
			break;

		while (z < l - 1 && s[z] == s[z+1])
			++z;
		i = z;
		while (a > 0 && z < l - 1 && s[a-1] == s[z+1]) {
			--a;
			++z;
		}
		if (z - a + 1 > max_len) {
			max_len = z - a + 1;
			max_start = a;
		}
	}

	ans = malloc((max_len+1) * sizeof(char));
	strncpy(ans, s+max_start, max_len);

	return ans;
}

int main(int argc, char **argv)
{
	char *ans;

	if (argc < 2)
		return 1;

	printf("%s:\n", argv[1]);
	ans = longestPalindrome(argv[1]);
	printf("%s\n", ans);
	free(ans);

	return 0;
}
