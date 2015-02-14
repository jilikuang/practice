#include <stdio.h>

static int length_of_longest_substring(char *s) {
	int ch_cnt[96];	// Dictionary: last index of characters
	int start = 0, end = 0;
	int length = 0;
	int i = 0;

	// Initialize the dictionary
	for (i = 0; i < 96; i++)
		ch_cnt[i] = -1;

	while (*s != '\0') {
		int ch_idx = *s - ' ';

		if (ch_cnt[ch_idx] >= 0) {
			// The current character has shown
			// Compare the current length
			if (length < end - start)
				length = end - start;
			/* If the last time is in the current substring,
			 * reset the start of the substring */
			if (start < ch_cnt[ch_idx] + 1)
				start = ch_cnt[ch_idx] + 1;
		}

		// Update the index of the character
		ch_cnt[ch_idx] = end;
		end++;
		s++;
	}

	// Handle for the boundary condition
	if (length < end - start)
		length = end - start;

	return length;
}

int main(int argc, char **argv) {
	if (argc < 2) {
		printf("Need a string input\n");
		return -1;
	}

	printf("The length of the longest substring is %d\n",
			length_of_longest_substring(argv[1]));

	return 0;
}
