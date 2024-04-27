#define	NULL	0

struct node {
	char data;
	struct node *link;
};

// �ͦ��@�ӷs���`�I
struct node * new(){
	struct node *p;

	p = (struct node *)malloc(sizeof(struct node));
	return p;
} // end new

struct node *list;

struct node * create(){
	struct node *p, *q; 
	int i,n,d;

	list=new(); list->link=NULL;
	p=list;

	printf("�n��J�h�ֵ�? "); scanf("%d", &n);

	for (i=0; i<n; i++){
		printf("��J�� %d �����", i+1);scanf("%d", &d);
		q=new(); q->data=d; q->link=NULL;
		p->link=q;
		p=q;
	}
} // end create

void display(){
	struct node *c;
	c = list->link;

	while (c){
		printf("%d", c->data);
		c=c->link;
	}
}

// �[�s�`�I q �� p ����
void insert(struct node *p, struct node *q){
	printf("x\n");
	q->link=p->link;
	printf("y\n");
	p->link=q;
	printf("z\n");
}

// �D�{��
main(){
	struct node *t, *last;
	create();
	display(); printf("\n");

	t = new(); t->data=3; t->link=NULL;

	last = list->link;
	while (last != NULL){
		last=last->link;
	}

	insert(last,t);
	display(); printf("\n");
} // end main
