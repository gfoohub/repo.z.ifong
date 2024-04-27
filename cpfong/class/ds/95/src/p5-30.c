#define	NULL	0

struct node {
	int data;
	struct node *link;
};

// �ͦ��@�ӷs���I
struct node * new(){
	struct node *p;
	p = (struct node *) malloc(sizeof(struct node));
	if (p == NULL){
		printf("out of memory");
		exit(1);
	}
	return(p);
} // end new

// �ͦ��@���I
struct node * create(){
	struct node *list, *p, *q;
	int i, n, d;

	list=new(); list->link=NULL;
	p=list;

	printf("�Q�ͦ��h�֭Ӹ`�I? ");
	scanf("%d", &n);
	for (i=1; i<=n; i++){
		printf("��J�� %d ��: ", i);
		scanf("%d", &d);;
		q=new(); q->data=d; q->link=NULL;
		p->link=q;
		p=q;
	}
	return (list);
} // end create

// ��S�w���
struct node * search (struct node *list, int d){
	struct node *p;
	p=list->link;

	while(p != NULL && p->data != d){
		p=p->link;
	}
	return (p);
} // end search 

// �� q �I���e�@�Ӹ`�I p
struct node * prenode(struct node *list, struct node *q){
	struct node *p;
	p=list;
	while (p != NULL && p->link != q){
		p=p->link;
	}
	return (p);
} // end prenode

void insert (struct node *p, struct node *q){
	q->link=p->link;
	p->link=q;
} // end insert

void delete (struct node *p, struct node *q){
	p->link=q->link;
	free(q);
}  // end delete

int length(struct node *list){
	struct node *p;
	int count=0;

	p=list->link;
	while(p != NULL){
		count++;
		p=p->link;
	}
	return(count);
} // end leght

void display(struct node *list){
	struct node *p;

	p=list->link;
	while (p != NULL){
		printf("%5d", p->data);
		p=p->link;
	}
	printf("\n");
} // end display

main(){
	struct node *list, *p, *q;
	int loop=1, d, d1;
	char input[8];

	printf("*** �쵲 ***\n");
	printf("��J�H�W���ʧ@: create insert delete display length exit\n\n"); 
	list =NULL;

	while (loop){
		printf("===>");
		scanf("%s", input);
		if (strcmp(input, "create") == 0){
			list = create();
		}
		else if (strcmp(input, "insert") == 0){
			printf("�A�Q��J�����: ");
			scanf("%d", &d);
			q=new(); q->data=d;
			printf("�b���@����Ƥ���? ");
			scanf("%d", &d1);
			p=search(list, d1);
			if (p == NULL){
				printf("cannot find %d, insert to front\n", d1);
				p=list;
			}
			insert(p,q);
		}
		else if (strcmp(input, "delete") == 0){
			printf("�Q�R���@��? ");
			scanf("%d", &d);
			q=search(list, d);
			if (q == NULL){
				printf("cannot find %d, cannot delete\n", d);
			}
			else {
				p=prenode(list,q);
				delete(p,q);
			}
		} 
		else if (strcmp(input, "display") == 0){
			display(list);
		}
		else if (strcmp(input, "length") == 0){
			printf("���쵲�����׬� %d\n", length(list));
		}
		else if (strcmp(input, "exit") == 0){
			loop=0;
		}
		else {
			printf("��J���~, ����\n");
		}
	} // end of while
} // end main
