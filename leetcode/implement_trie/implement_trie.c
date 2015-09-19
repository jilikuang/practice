#include "../utils.h"

struct TrieNode {
	char c;
	struct TrieNode *next;
	struct TrieNode *children;
};

static struct TrieNode * trieCreate() {
	struct TrieNode *node = malloc(sizeof(struct TrieNode));

	node->c = '\0';
	node->next = NULL;
	node->children = NULL;

	return node;
}

static void trieInsert(struct TrieNode *root, char *word)
{
	if (root && *word) {
		struct TrieNode *level = root;
		struct TrieNode *curr = root;
		struct TrieNode *prev = NULL;

		for (; ; ++word, level = curr->children) {
			for (curr = level, prev = NULL; curr; prev = curr, curr = curr->next)
				if (curr->c == *word)
					break;

			if (!curr) {
				curr = trieCreate();
				curr->c = *word;
				prev->next = curr;
			}

			if (*word == '\0')
				break;

			if (!curr->children) {
				curr->children = trieCreate();
				curr->children->c = *(word+1);
			}
		}
	}
}

static int trieSearch(struct TrieNode *root, char *word) {
	int found = 0;

	if (root) {
		struct TrieNode *level = root;

		while (level) {
			struct TrieNode *curr;

			/* search the current level */
			for (curr = level; curr; curr = curr->next)
				if (curr->c == *word)
					break;

			printf("%p\n", curr);
			if (!curr)
				break;

			if (*word == '\0') {
				found = 1;
				break;
			}

			/* match till now */
			level = curr->children;
			++word;
		}
	}

	return found;
}

static int trieStartsWith(struct TrieNode *root, char *prefix)
{
	int found = 0;

	if (root) {
		struct TrieNode *level = root;

		while (level && *prefix) {
			struct TrieNode *curr;

			for (curr = level; curr; curr = curr->next)
				if (curr->c == *prefix)
					break;

			if (!curr)
				break;

			level = curr->children;
			++prefix;
		}

		if (*prefix == '\0')
			found = 1;
	}

	return found;
}

static void trieFree(struct TrieNode *root) {
	if (root) {
		trieFree(root->next);
		trieFree(root->children);
		free(root);
	}
}

static void triePrint(struct TrieNode *root, int level) {
	if (root) {
		struct TrieNode *curr;

		for (curr = root; curr; curr = curr->next) {
			printf("[%d] %c\n", level, (curr->c) ? : '#');
			triePrint(curr->children, level+1);
		}
	}
}

int main(int argc, char **argv)
{
	struct TrieNode *root = trieCreate();

	trieInsert(root, "abc");
	printf("%d\n", trieSearch(root, "abc"));
	printf("%d\n", trieSearch(root, "ab"));
	trieInsert(root, "ab");
	printf("%d\n", trieSearch(root, "ab"));
	trieInsert(root, "ab");
	printf("%d\n", trieSearch(root, "ab"));
	triePrint(root, 0);
	trieFree(root);

	return 0;
}
