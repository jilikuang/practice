#include "../utils.h"

typedef struct RomanDict {
	char c;
	int n;
} RomanDict;

static int get_integer(const char c)
{
	int i;
	RomanDict dict[7] = {
		{'M', 1000},
		{'D', 500},
		{'C', 100},
		{'L', 50},
		{'X', 10},
		{'V', 5},
		{'I', 1}
	};

	for (i = 0; i < 7; ++i)
		if (c == dict[i].c)
			break;
	return dict[i].n;
}

static int roman_to_integer(char *s)
{
	char *c;
	int num = 0, sum = 0;

	for (c = s; *c != '\0'; ++c) {
		int curr = get_integer(*c);
		int next = get_integer(*(c+1));

		if (curr == next) {
			sum += curr;
		} else if (curr < next) {
			sum = -(sum + curr);
		} else {
			num += sum + curr;
			sum = 0;
		}
	}

	return num;
}

int main(int argc, char **argv)
{
	char *roman = "DCXXI";

	printf("%d\n", roman_to_integer(roman));
	return 0;
}
