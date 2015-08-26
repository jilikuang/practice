#include <stdio.h>

int single_number(int *nums, int numsSize)
{
	int ans = 0;
	int i;

	for (i = 0; i < numsSize; ++i)
		ans ^= nums[i];

	return ans;
}

int main(int argc, char **argv)
{
	int nums[5] = {1, 2, 3, 2, 1};

	printf("%d\n", single_number(nums, 5));

	return 0;
}
