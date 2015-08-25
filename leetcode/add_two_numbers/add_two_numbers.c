#include "../utils.h"

struct ListNode * add_two_numbers(struct ListNode *l1, struct ListNode *l2)
{
	struct ListNode *head = (l1) ? : l2;
	struct ListNode *prev;
	int c = 0;

	if (l1 == NULL || l2 == NULL)
		return head;

	head = l1;

	while (l1) {
		int v2 = (l2) ? l2->val : 0;

		l1->val += v2 + c;
		c = l1->val > 9;
		if (c)
			l1->val -= 10;

		if (!l1->next && l2) {
			l1->next = l2->next;
			l2->next = NULL;
		}

		prev = l1;
		l1 = l1->next;
		if (l2)
			l2 = l2->next;
	}

	if (c) {
		prev->next = malloc(sizeof(struct ListNode));
		prev->next->val = c;
		prev->next->next = NULL;
	}

	return head;
}

int main(int argc, char **argv) {
	struct ListNode *l1, *l2;
	struct ListNode *ans;

	list_append(&l1, 9);

	list_append(&l2, 9);
	list_append(&l2, 9);
	list_append(&l2, 9);

	list_print(l1);
	list_print(l2);

	ans = add_two_numbers(l1, l2);

	list_print(ans);
	list_print(l1);
	list_print(l2);

	list_release(l1);
	list_release(l2);

	return 0;
}
