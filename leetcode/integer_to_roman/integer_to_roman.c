#include "../utils.h"

typedef struct RomanDict {
	int n;
	char *s;
} RomanDict;

static RomanDict dict[13] = {
	{1000, "M"},
	{ 900, "CM"},
	{ 500, "D"},
	{ 400, "CD"},
	{ 100, "C"},
	{  90, "XC"},
	{  50, "L"},
	{  40, "XL"},
	{  10, "X"},
	{   9, "IX"},
	{   5, "V"},
	{   4, "IV"},
	{   1, "I"}
};

static char * integer_to_roman(int num)
{
	int i;
	ALLOC_ARRAY(roman, char, 64);

	roman[0] = '\0';
	while (num) {
		for (i = 0; i < 13; ++i)
			if (num >= dict[i].n)
				break;
		strcat(roman, dict[i].s);
		num -= dict[i].n;
	}

	return roman;
}

int main(int argc, char **argv)
{
	char *roman = integer_to_roman(1);

	printf("%s\n", roman);

	free(roman);

	return 0;
}
