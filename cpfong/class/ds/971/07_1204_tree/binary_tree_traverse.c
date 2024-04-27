#define	NULL	0
struct tnode{
	char data;
	struct tnode *left;
	struct tnode *right;
};

struct tnode *new(){
	struct tnode *p;
	p=(struct tnode *)malloc(sizeof(struct tnode));
	return (p);
} // end new

struct tnode *make_tree(char d){
	struct tnode *tree=NULL;
	char ldata,rdata,t;

	if (d != '0'){
		tree=new();
		tree->data=d;
		printf("\ninput %c ���l�`�I��: ",d); ldata=getchar(); t=getchar();
		printf("\ninput %c �k�l�`�I��: ",d); rdata=getchar(); t=getchar();
		tree->left =make_tree(ldata);
		tree->right=make_tree(rdata);
	}
	return(tree);
}// end make_tree

void preorder(struct tnode *p){
	if (p != NULL){
		printf("%2c",p->data);
		preorder(p->left);
		preorder(p->right);
	}
} // end preorder
void inorder(struct tnode *p){
	if (p != NULL){
		inorder(p->left);
		printf("%2c",p->data);
		inorder(p->right);
	}
} // end inorder
void postorder(struct tnode *p){
	if (p != NULL){
		postorder(p->left);
		postorder(p->right);
		printf("%2c",p->data);
	}
} // end postorder

main(){
	struct tnode *tree;
	char data,t;

	printf("*** �G���𪺫إ� ***\n");
	printf("�Y�o�Ӹ�ƤU��S������`�I, ��J�Ʀr 0\n\n");
	printf("��J��ڸ`�I���: ");
	data=getchar(); t=getchar();
	tree=make_tree(data);
	printf("�e�Ǩ��X: "); preorder (tree); printf("\n");
	printf("���Ǩ��X: "); inorder  (tree); printf("\n");
	printf("��Ǩ��X: "); postorder(tree); printf("\n");
} // end main
