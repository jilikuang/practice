#include "../utils.h"

static int minSubArrayLen(int s, int *nums, int numsSize)
{
	int ans = numsSize;
	int l = 0, r = 0;
	int sum = nums[r];

	while (r < numsSize) {
		if (sum >= s) {
			if (l == r)
				return 1;

			if (r - l + 1 < ans)
				ans = r - l + 1;

			sum -= nums[l++];
		} else {
			++r;
			if (r < numsSize)
				sum += nums[r];
		}
	}

	if (ans == numsSize && sum < s)
		ans = 0;

	return ans;
}

int main(int argc, char **argv)
{
	int array[3] = {1, 4, 4};

	printf("%d\n", minSubArrayLen(4, array, 3));

	return 0;
}
