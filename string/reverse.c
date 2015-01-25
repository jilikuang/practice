#include <stdio.h>
#include <string.h>

static void reverse(char *str) {
	int i, l = strlen(str);
	char tmp;

	for (i = 0; i < l/2; i++) {
		tmp = str[i];
		str[i] = str[l-1-i];
		str[l-1-i] = tmp;
	}
}

int main(int argc, char **argv) {

	if (argc < 2) {
		printf("Need a string input\n");
		return -1;
	}

	printf("The input is: \"%s\"\n", argv[1]);

	reverse(argv[1]);

	printf("The reversed: \"%s\"\n", argv[1]);

	return 0;
}
