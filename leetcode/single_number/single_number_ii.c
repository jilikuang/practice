#include "../utils.h"

int single_number(int *nums, int numsSize)
{
	int counts[3] = {0, 0, 0};
	int i;

	for (i = 0; i < numsSize; ++i) {
		counts[1] |= counts[0] & nums[i];	// twos if ones has
		counts[0] ^= nums[i];			// ones for 1 or 3
		counts[2] = counts[0] & counts[1];	// threes if ones and twos
		counts[0] &= ~counts[2];		// ones discard thress
		counts[1] &= ~counts[2];		// twos discard threes
	}

	return counts[0];
}

int main(int argc, char **argv)
{
	int nums[4] = {45, 45, 45, 57};

	printf("%d\n", single_number(nums, 4));

	return 0;
}
