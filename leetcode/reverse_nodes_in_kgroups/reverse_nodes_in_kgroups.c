#include "../utils.h"

static struct ListNode * reverse(struct ListNode *prev, struct ListNode *stop)
{
	struct ListNode *head = prev->next;
	struct ListNode *newPrev = head;

	if (head->next != stop) {
		struct ListNode *next = head->next;

		head->next = stop;
		while (next != stop) {
			struct ListNode *curr = next;
			next = curr->next;
			curr->next = head;
			head = curr;
		}
		prev->next = head;
	}

	return newPrev;
}

static struct ListNode * reverseKGroup(struct ListNode *head, int k)
{
	struct ListNode dummy = {0, head};
	struct ListNode *prev = &dummy;
	struct ListNode *curr = head;
	int i = k;

	while (curr) {
		if (--i == 0) {
			prev = reverse(prev, curr->next);
			i = k;
			curr = prev;
		}
		curr = curr->next;
	}

	return dummy.next;
}

int main(int argc, char **argv)
{
	struct ListNode *head = list_create(argv[2]);

	list_print(head);
	head = reverseKGroup(head, strtol(argv[1], NULL, 0));
	list_print(head);
	list_release(head);

	return 0;
}
