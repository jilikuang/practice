#ifndef __UTILS__
#define __UTILS__

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

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

void array_print_int(int *nums, int size)
{
	int i;

	printf("[%d", nums[0]);
	for (i = 1; i < size; ++i)
		printf(", %d", nums[i]);
	printf("]\n");
}

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

struct ListNode * list_create(char *str)
{
	struct ListNode *head = NULL;
	char *token, delim[3] = ", ";

	token = strtok(str, delim);
	while (token) {
		list_append(&head, strtol(token, NULL, 0));
		token = strtok(NULL, delim);
	}

	return head;
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

void tree_append(struct TreeNode **p_node, int val)
{
	if (!p_node) {
		printf("Invalid tree node pointer\n");
		return;
	}

	if (*p_node) {
		printf("Input node must be NULL\n");
	} else {
		*p_node = malloc(sizeof(struct TreeNode));
		(*p_node)->val = val;
		(*p_node)->left = NULL;
		(*p_node)->right = NULL;
	}
}

void tree_release(struct TreeNode *root)
{
	if (root == NULL)
		return;

	tree_release(root->left);
	tree_release(root->right);
	free(root);
}

#endif	// __UTILS__
