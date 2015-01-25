#include <stdio.h>
#include <string.h>

static int permutation_check_map(char *s1, char *s2) {
	int i, idx;
	int l1 = strlen(s1);
	int l2 = strlen(s2);
	int char_count[256];

	if (l1 != l2)
		return 0;

	memset(char_count, 0, sizeof(int) * 256);

	for (i = 0; i < l1; i++) {
		idx = (int)s1[i];
		char_count[idx]++;
	}

	for (i = 0; i < l2; i++) {
		idx = (int)s2[i];
		if (char_count[idx] == 0)
			return 0;
		char_count[idx]--;
	}

	return 1;
}

static void sort_string(char *s, int l) {
	int i = 0, j = 1;
	char tmp;

	if (l < 2)
		return;

	for (j = 1; j < l; j++)
		if (s[j] < s[0]) {
			i++;
			if (j > i) {
				tmp = s[j];
				s[j] = s[i];
				s[i] = tmp;
			}
		}

	if (i > 0) {
		tmp = s[i];
		s[i] = s[0];
		s[0] = tmp;
	}

	sort_string(s, i);
	sort_string(s+i+1, l-i-1);
}

static int permutation_check_sort(char *s1, char *s2) {
	int i;
	int l1 = strlen(s1);
	int l2 = strlen(s2);

	if (l1 != l2)
		return 0;

	sort_string(s1, l1);
	sort_string(s2, l2);

	for (i = 0; i < l1; i++)
		if (s1[i] != s2[i])
			return 0;

	return 1;
}

int main(int argc, char **argv) {

	if (argc < 3) {
		printf("Need two string inputs\n");
		return -1;
	}

	printf("The 1st string: %s\n", argv[1]);
	printf("The 2nd string: %s\n", argv[2]);

	if (permutation_check_map(argv[1], argv[2]))
		printf("The two strings are anagrams\n");
	else
		printf("The two strings are NOT anagrams\n");

	return 0;
}
