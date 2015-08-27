#include "../utils.h"

int * single_number(int *nums, int numsSize, int *returnSize)
{
	ALLOC_ARRAY(ans, int, *returnSize);
	int i, x = 0;

	for (i = 0; i < numsSize; ++i)
		x ^= nums[i];

	x ^= x & (x - 1);	// Keep the least bit 1 for grouping

	ans[0] = 0;
	ans[1] = 0;
	for (i = 0; i < numsSize; ++i)
		ans[(x & nums[i]) == 0] ^= nums[i];

	return ans;
}

int main(int argc, char **argv)
{
	int nums[2] = {-1, 0};
	int size = 2;
	int *ans;

	ans = single_number(nums, 2, &size);
	array_print_int(ans, size);

	free(ans);

	return 0;
}
