#include <stdio.h>
#include <stdlib.h>
#include <time.h>

static void print_array(int *nums, int size)
{
	int i;

	printf("[");
	for (i = 0; i < size; ++i)
		if (i == 0)
			printf("%d", nums[i]);
		else
			printf(", %d", nums[i]);
	printf("]\n");
}

static int * generate_array(int size, int max)
{
	int *nums = (int *)malloc(size *sizeof(int));
	int i;

	for (i = 0; i < size; ++i)
		nums[i] = rand() % max;

	return nums;
}

static inline void swap(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

static int partition_nondecreasing(int *nums, int start, int end)
{
	int i = start, j = end;

	while (i < j) {
		while (i <= end && nums[i] <= nums[start])
			++i;
		while (j > start && nums[j] >= nums[start])
			--j;
		if (i < j)
			swap(nums+i, nums+j);
		else
			break;
	}
	swap(nums+start, nums+j);
	return j;
}

static int partition_nonincreasing(int *nums, int start, int end)
{
	int i = start, j = end;

	while (i < j) {
		while (i < end && nums[i] >= nums[end])
			++i;
		while (j >= start && nums[j] < nums[end])
			--j;
		if (i < j)
			swap(nums+i, nums+j);
		else
			break;
	}
	swap(nums+end, nums+i);
	return i;
}

static void quicksort_nonincreasing(int *nums, int start, int end)
{
	if (start < end) {
		int p = partition_nonincreasing(nums, start, end);
		quicksort_nonincreasing(nums, start, p - 1);
		quicksort_nonincreasing(nums, p + 1, end);
	}
}

static void quicksort_nondecreasing(int *nums, int start, int end)
{
	if (start < end) {
		int p = partition_nondecreasing(nums, start, end);
		quicksort_nondecreasing(nums, start, p - 1);
		quicksort_nondecreasing(nums, p + 1, end);
	}
}

static int verify_nondecreasing(int *nums, int size)
{
	int i;

	for (i = 1; i < size; ++i)
		if (nums[i] < nums[i-1])
			return 0;
	return 1;
}

static int verify_nonincreasing(int *nums, int size)
{
	int i;

	for (i = 1; i < size; ++i)
		if (nums[i] > nums[i-1])
			return 0;
	return 1;
}

int main(int argc, char **argv)
{
	int *nums, size = 10;
	int iter = 10000;
	int i;

	srand((unsigned int)time(NULL));

	for (i = 0; i < iter; ++i) {
		nums = generate_array(size, 50);
		//print_array(nums, size);
		if (rand() & 1) {
			quicksort_nondecreasing(nums, 0, size - 1);
			if (!verify_nondecreasing(nums, size)) {
				printf("error!\n");
				print_array(nums, size);
			}
		} else {
			quicksort_nonincreasing(nums, 0, size - 1);
			if (!verify_nonincreasing(nums, size)) {
				printf("error!\n");
				print_array(nums, size);
			}
		}
		//print_array(nums, size);
		free(nums);
	}
	printf("testing done\n");
	return 0;
}
