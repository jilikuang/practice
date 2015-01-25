#include <stdlib.h>
#include <stdio.h>
#include <string.h>

static void replace_spaces(char *s) {
	int space_count = 0;
	char *curr = s;

	while (*curr != '\0')
		if (*(curr++) == ' ')
			space_count++;

	if (space_count == 0)
		return;

	s = curr - 1;
	curr += space_count * 2;
	*(curr--) = '\0';

	while (curr > s) {
		if (*s == ' ') {
			*(curr--) = '0';
			*(curr--) = '2';
			*(curr--) = '%';
			s--;
		} else {
			*(curr--) = *(s--);
		}
	}
}

static char *render_input(int argc, char **argv) {
	int i = 0;
	int size = 0;
	char *str_new = NULL;
	char *curr = NULL;

	for (i = 1; i < argc; i++)
		size += strlen(argv[i]) + 3;

	// Total length + space counts * 3 + '\0'
	size -= 2;

	str_new = (char *)malloc(size * sizeof(char));
	curr = str_new;

	for (i = 1; i < argc; i++) {
		strcpy(curr, argv[i]);
		curr += strlen(argv[i]);
		*(curr++) = ' ';
	}

	*(--curr) = '\0';

	return str_new;
}

int main(int argc, char **argv) {
	char *input;

	if (argc < 2) {
		printf("Need string inputs\n");
		return -1;
	}

	input = render_input(argc, argv);

	printf("The input: %s\n", input);

	replace_spaces(input);

	printf("The result: %s\n", input);

	return 0;
}
