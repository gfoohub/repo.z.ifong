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

// �D�{��
main(){
	struct node *t;
	create();
	display();
} // end main
