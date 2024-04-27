#include<stdlib.h>
#include<stdio.h>

struct tree_template {
	int val;
	struct tree_template *right, *left;
};

typedef struct tree_template node;

//
// �ۮڶ}�l�[�@�Ӹ`�I
// �`�N: �Ĥ@�ӰѼƬ��ڪ���}, �ĤG�ӰѼƬ��@�ӫ���, ���V�s���ͪ��`�I
// ex: insert(&root, curr);
//

void insert(node **tree, node *item) {
	if(!(*tree)) { // hit the end, rebound back
		*tree = item;
		return;
	}
	if(item->val < (*tree)->val) {
		insert(&(*tree)->left, item);
	}
	else if(item->val > (*tree)->val) {
		insert(&(*tree)->right, item);
	}
} // end insert

void printout(node * tree) {
	if(tree->left) { printout(tree->left) ; }
	printf("%d ",tree->val);
	if(tree->right){ printout(tree->right); }
} // end printout

main() {
	node *curr, *root;
	int i;

	root = NULL;

	for(i=0;i<10;i++) {
		curr = (node *)malloc(sizeof(node));
		curr->left = curr->right = NULL;
		curr->val  = (int)rand()%100;
		insert(&root, curr);
	}
	printout(root);
	printf("\n");
} // end main
