#include <stdio.h>
#include <string.h>

int main(int argc, char **argv) {
	int i, l;

	if (argc < 2) {
		printf("Need a string input\n");
		return -1;
	}

	printf("The input is: \"%s\"\n", argv[1]);

	l = strlen(argv[1]);
	for (i = 0; i < l/2; i++) {
		char tmp = argv[1][i];
		argv[1][i] = argv[1][l-1-i];
		argv[1][l-1-i] = tmp;
	}

	printf("The reversed: \"%s\"\n", argv[1]);

	return 0;
}
