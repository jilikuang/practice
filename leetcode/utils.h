#ifndef __UTILS__
#define __UTILS__

#include <stdlib.h>
#include <stdio.h>

#define ALLOC_ARRAY(var, type, size)\
	type *var = malloc((size) * sizeof(type))

struct ListNode {
	int val;
	struct ListNode *next;
};

struct TreeNode {
	int val;
	struct TreeNode *left;
	struct TreeNode *right;
};

/*
 * Functions
 */

void list_append(struct ListNode **p_head, int val)
{
	if (!p_head) {
		printf("Invalid list head pointer!\n");
		return;
	}

	if (*p_head) {
		struct ListNode *head = *p_head;

		while (head->next)
			head = head->next;

		head->next = malloc(sizeof(struct ListNode));
		head->next->val = val;
		head->next->next = NULL;
	} else {
		*p_head = malloc(sizeof(struct ListNode));
		(*p_head)->val = val;
		(*p_head)->next = NULL;
	}
}

void list_release(struct ListNode *head)
{
	while (head) {
		struct ListNode *curr = head;

		head = curr->next;
		free(curr);
	}
}

void list_print(struct ListNode *head)
{
	printf("[");
	while (1) {
		printf("%d", head->val);
		if (!head->next)
			break;
		printf(", ");
		head = head->next;
	}
	printf("]\n");
}

#endif	// __UTILS__
